package com.winnie.action;
import com.winnie.utility.Email;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/send-mail")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,   // 2MB
        maxFileSize = 1024 * 1024 * 10,                 // 10MB - file size of uploaded files
        maxRequestSize = 1024 * 1024 * 50)              // 50MB
public class SendMailAction extends HttpServlet {

   /* @EJB
    TenantBeanI tenantBean;*/
    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    /**
     * handles form submission
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();

        List<File> uploadedFiles = saveUploadedFiles(request);

       /* httpSession.setAttribute("tenantBean", tenantBean);*/

      /*  // Retrieve the Tenant directly using the TenantBean
        Tenant tenant = tenantBean.tenantByEmail(email);*/
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        String resultMessage = "";

        try {
            Email.sendEmailWithAttachment(host, port, user, pass,
                    recipient, subject, content, uploadedFiles);

            resultMessage = "<h3>Success!</h3>" +
                    "<h5>Your e-mail has been successfully sent to <b>" + recipient + "</b>.</h5>" +
                    "<a href=\"./send_mail.jsp\" class=\"btn btn-danger\" >\n" +
                    "    Send Another e-Mail\n" +
                    "</a>\n";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            deleteUploadFiles(uploadedFiles);
            request.setAttribute("message", resultMessage);
            getServletContext().getRequestDispatcher("/mail_results.jsp").forward(
                    request, response);



        }
    }

    /**
     * Saves files uploaded from the client and return a list of these files
     * which will be attached to the e-mail message.
     */
    private List<File> saveUploadedFiles(HttpServletRequest request)
            throws IllegalStateException, IOException, ServletException {
        List<File> listFiles = new ArrayList<File>();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        Collection<Part> multiparts = request.getParts();
        if (multiparts.size() > 0) {
            for (Part part : request.getParts()) {
                // creates a file to be saved
                String fileName = extractFileName(part);
                if (fileName == null || fileName.equals("")) {
                    // not attachment part, continue
                    continue;
                }

                File saveFile = new File(fileName);
                System.out.println("saveFile: " + saveFile.getAbsolutePath());
                FileOutputStream outputStream = new FileOutputStream(saveFile);

                // saves uploaded file
                InputStream inputStream = part.getInputStream();
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.close();
                inputStream.close();

                listFiles.add(saveFile);
            }
        }
        return listFiles;
    }

    /**
     * Retrieves file name of a upload part from its HTTP header
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return null;
    }

    /**
     * Deletes all uploaded files, should be called after the e-mail was sent.
     */
    private void deleteUploadFiles(List<File> listFiles) {
        if (listFiles != null && listFiles.size() > 0) {
            for (File aFile : listFiles) {
                aFile.delete();
            }
        }
    }
}
