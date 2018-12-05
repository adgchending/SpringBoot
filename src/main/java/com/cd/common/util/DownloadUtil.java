/**
 * Copyright © 2017 eaglesoul100 All rights reserved.
 * <p>
 * 功能描述：
 *
 * @Package: com.es.app_common.util
 * @author: lvyonggang
 * @date: 2017年10月17日 下午8:22:44
 */
package com.cd.common.util;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class DownloadUtil {

    private final static Logger LOG = LoggerFactory
            .getLogger(DownloadUtil.class);

    /**
     *
     * @Function: parseByteArrayToResponseEntity(byte[] fileByte, String fileName)
     * @Description: 将byte[]类型的文件转换ResponseEntity<Resource>
     *
     * @param:fileByte 文件的byte[]数组类型
     * @param:fileName 文件名(带文件的后缀名 ， 如 ： test.pdf)
     * @return：ResponseEntity<Resource>
     * @throws：所有的异常都抛出，不抛出具体的异常
     *
     * @version: v1.0.0
     * @author: lvyonggang
     * @date: 2017年10月18日 上午9:14:59
     *
     *        Modification History: Date Author Version Description
     *        ---------------------------------------------------------*
     *        2017年10月18日 lvyonggang v1.0.0 创建
     */
    public static ResponseEntity<Resource> parseByteArrayToResponseEntity(
            byte[] fileByte, String fileName) throws Exception {
        // 获取文件名，将文件名用utf-8来编码，不然文件名中文是乱码
        fileName = URLEncoder.encode(fileName,
                StandardCharsets.UTF_8.toString()).replaceAll("\\+", "%20");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.set("Content-Disposition", "attachment; filename=\"" + fileName
                + "\"; filename*=utf-8''" + fileName);
        InputStreamResource inputStreamResource = new InputStreamResource(
                new ByteArrayInputStream(fileByte));
        //设置文件内容大小
        headers.setContentLength(fileByte.length);
        return new ResponseEntity<>(inputStreamResource, headers,
                HttpStatus.OK);
    }

    /**
     * 可以指定文件类型来生成ResponseEntity
     * @param fileByte
     * @param fileName
     * @param mediaType
     * @return
     * @throws Exception
     */
    public static ResponseEntity<Resource> parseByteArrayToResponseEntityByMediaType(
            byte[] fileByte, String fileName,MediaType mediaType) throws Exception {
        // 获取文件名，将文件名用utf-8来编码，不然文件名中文是乱码
        fileName = URLEncoder.encode(fileName,
                StandardCharsets.UTF_8.toString()).replaceAll("\\+", "%20");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        headers.set("Content-Disposition", "attachment; filename=\"" + fileName
                + "\"; filename*=utf-8''" + fileName);
//        headers.set("Content-Disposition",String.format("attachment; filename=\"%s\"", fileName));
        //允许跨域
        headers.setAccessControlAllowOrigin("*");
        InputStreamResource inputStreamResource = new InputStreamResource(
                new ByteArrayInputStream(fileByte));
        //设置文件内容大小
        headers.setContentLength(fileByte.length);
        return new ResponseEntity<>(inputStreamResource, headers,
                HttpStatus.OK);
    }


    /**
     *
     * @Function: parseByteArrayToResponseEntity(byte[] fileByte, String fileName)
     * @Description: 将byte[]类型的文件转换ResponseEntity<Resource> 文件只能预览，不能下载
     *
     * @param:fileByte 文件的byte[]数组类型
     * @param:fileName 文件名(带文件的后缀名 ， 如 ： test.pdf)
     * @return：ResponseEntity<Resource>
     * @throws：所有的异常都抛出，不抛出具体的异常
     *
     * @version: v1.0.0
     * @author: lvyonggang
     * @date: 2017年10月18日 上午9:14:59
     *
     *        Modification History: Date Author Version Description
     *        ---------------------------------------------------------*
     *        2017年10月18日 lvyonggang v1.0.0 创建
     */
    public static ResponseEntity<Resource> parseByteArrayToRNotDownload(
            byte[] fileByte, String fileName) throws Exception {
        // 获取文件名，将文件名用utf-8来编码，不然文件名中文是乱码
        fileName = URLEncoder.encode(fileName,
                StandardCharsets.UTF_8.toString());

        // 获取文件的文件类型
        // net.sf.jmimemagic.Magic;
        MagicMatch match = Magic.getMagicMatch(fileByte);

        if (LOG.isDebugEnabled()) {
            LOG.debug("MineType of the file is: {}", match.getMimeType());
        }

        MediaType mediaType = MediaType.valueOf(match.getMimeType());

        // 设置header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        headers.set("Content-Disposition", "filename=\"" + fileName
                + "\"; filename*=utf-8''" + fileName);

        InputStreamResource inputStreamResource = new InputStreamResource(
                new ByteArrayInputStream(fileByte));

        return new ResponseEntity<>(inputStreamResource, headers,
                HttpStatus.OK);
    }
}
