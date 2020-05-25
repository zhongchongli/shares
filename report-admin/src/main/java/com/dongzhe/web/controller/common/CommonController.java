package com.dongzhe.web.controller.common;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.dongzhe.common.base.AjaxResult;
import com.dongzhe.common.config.Global;
import com.dongzhe.common.utils.file.FileUploadUtils;
import com.dongzhe.common.utils.file.FileUtils;
import com.dongzhe.framework.config.ServerConfig;

/**
 * 通用请求处理
 * 
 * @author zcl
 */
@Controller
public class CommonController
{
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    /**
     * 文件上传路径
     */
    public static final String UPLOAD_PATH = "/profile/upload/";

    @Autowired
    private ServerConfig serverConfig;

    /**
     * 通用下载请求
     * 
     * @param fileName 文件名称
     * @param delete 是否删除
     */
    @GetMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request)
    {
        String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
        try
        {
            String filePath = Global.getDownloadPath() + fileName;

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete)
            {
                FileUtils.deleteFile(filePath);
            }
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = Global.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + UPLOAD_PATH + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    public String setFileDownloadHeader(HttpServletRequest request, String fileName) throws UnsupportedEncodingException
    {
        final String agent = request.getHeader("USER-AGENT");
        String filename = fileName;
        if (agent.contains("MSIE"))
        {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        }
        else if (agent.contains("Firefox"))
        {
            // 火狐浏览器
            filename = new String(fileName.getBytes(), "ISO8859-1");
        }
        else if (agent.contains("Chrome"))
        {
            // google浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        else
        {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
    /**
     * 转换为pdf展示
     *
     * @param reportName
     * @param parameters
     * @param response
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws JRException
     * @throws IOException
     @GetMapping("/common/jasper/{reportName}")
     public void getReportByParam(@PathVariable("reportName") final String reportName, @RequestParam(required = false) Map<String, Object> parameters,
     HttpServletResponse response) throws SQLException, JRException, IOException {

     parameters = parameters == null ? new HashMap<>() : parameters;        //获取文件流

     parameters.put("reportNo", "LYLT19031621");
     parameters.put("sampleName", "山药");
     parameters.put("sampleOrg", "山东绿地食品有限公司");
     parameters.put("producer", "/");
     parameters.put("entrustOrg", "临沂市沂蒙路百货大楼");
     parameters.put("examType", "食品安全监督抽检");
     //        ClassPathResource resource = new ClassPathResource("jasper" + File.separator + reportName + ".jrxml");
     //        InputStream jasperStream = resource.getInputStream();
     //
     //        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
     org.springframework.core.io.Resource resource = new ClassPathResource("jasper/page1.jasper");
     org.springframework.core.io.Resource resource1 = new ClassPathResource("jasper/page3.jasper");
     //        InputStream is = resource.getInputStream();
     JasperPrint jasperPrint = JasperFillManager.fillReport(resource.getInputStream(), parameters, new JREmptyDataSource());        // JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());
     JasperPrint jasperPrint1 = JasperFillManager.fillReport(resource1.getInputStream(), parameters, new JREmptyDataSource());
     //        jasperPrint.add();
     List<JasperPrint> jasperPrintList = new ArrayList<>();
     jasperPrintList.add(jasperPrint);
     jasperPrintList.add(jasperPrint1);
     response.setContentType("application/pdf");
     response.setHeader("Content-Disposition", "inline;");
     final OutputStream outputStream = response.getOutputStream();
     JRPdfExporter exporter = new JRPdfExporter();
     exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
     //        exporter.setParameter(JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS, Boolean.TRUE);
     exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
     exporter.exportReport();
     }*/

}
