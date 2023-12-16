package com.winnie.app.bean;


import com.winnie.app.model.entity.AuditLog;
import com.winnie.app.model.entity.House;


import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Stateless
public class HouseBean extends GenericBean<House> implements HouseBeanI, Serializable {

    @Inject
    private Event<AuditLog> logger;


    public List<House> list() {
        return super.list(new House());
    }

    @Override
    public House add(House house) {
        house = getDao().add(house);

        // Log house addition details
        AuditLog log = new AuditLog();
        log.setLogDetails("A house with number " + house.getHouseNo() + " and name " + house.getHouseName() +
                " was added at " + DateFormat.getDateTimeInstance().format(new Date()) +
                " in " + house.getHouseLocation() + " area");
        logger.fire(log);

        // Log number of houses by type
        List<House> houseByType = getDao().getEm().createNamedQuery(House.HouseByType, House.class).getResultList();
        System.out.println("Number of houses with type 'Mansion': " + houseByType.size());
        System.out.println(houseByType);

        // Log number of houses by location
        List<House> houseByLocation = getDao().getEm().createNamedQuery(House.HouseByLocation, House.class).getResultList();
        System.out.println("Number of houses located in 'Roysambu': " + houseByLocation.size());
        System.out.println(houseByLocation);

        return house;
    }

    @Inject
    public void tryMethodInjection() {
        System.out.println("Method injection trial............");
    }

    // This method is for handling GET requests in a servlet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       /* // Retrieve the list of available houses

        List<House> availableHouses = listAvailableHouses();

        // Set the list of available houses as an attribute in the request
        request.setAttribute("availableHouses", availableHouses);

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("./vacant_houses.jsp");
        dispatcher.forward(request, response);*/
    }

    // This method retrieves a list of available houses
    public List<House> listAvailableHouses() {
        return getDao().getEm()
                .createQuery("FROM House h WHERE h.houseStatus= 'available'", House.class)
                .getResultList();
    }

    @Override
    public House getById(Long id) {
        return getDao().getById(House.class, id);
    }


}

