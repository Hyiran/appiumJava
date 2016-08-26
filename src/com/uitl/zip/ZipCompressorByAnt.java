package com.uitl.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
import org.testng.annotations.Test;

/**
 * @ClassName: ZipCompressorByAnt
 * @CreateTime 2016/5
 * @author : chaos
 * @Description: 压缩文件的通用工具类-采用ant中的org.apache.tools.ant.taskdefs.Zip来实现。
 * 
 */

public class ZipCompressorByAnt {

	public File zipFile;

	/**
	 * 压缩文件构造函数
	 * 
	 * @param pathName
	 *            最终压缩生成的压缩文件：目录+压缩文件名.zip
	 */
	public ZipCompressorByAnt(String finalFile) {
		zipFile = new File(finalFile);
	}

	/**
	 * 执行压缩操作
	 * 
	 * @param srcPathName
	 *            需要被压缩的文件/文件夹
	 * @throws InterruptedException 
	 */
	public void compressExe(String srcPathName) throws InterruptedException {
		File srcdir = new File(srcPathName);
		if (!srcdir.exists()) {
			throw new RuntimeException(srcPathName + "不存在！");
		}

		Project prj = new Project();
		Zip zip = new Zip();
		System.out.println("开始压缩。。。。");
		zip.setProject(prj);
		zip.setDestFile(zipFile);
		FileSet fileSet = new FileSet();
		fileSet.setProject(prj);
		fileSet.setDir(srcdir);
		// fileSet.setIncludes("**/*.java"); //包括哪些文件或文件夹
		// eg:zip.setIncludes("*.java");
		// fileSet.setExcludes(...); //排除哪些文件或文件夹
		zip.addFileset(fileSet);
		zip.execute();
        Thread.sleep(60000);
		System.out.println("压缩完成");
	}
	
	/** 
     * 复制整个文件夹的内容(含自身) 
     * @param oldPath 准备拷贝的目录 
     * @param newPath 指定绝对路径的新目录 
     * @return 
     */  
    public static  void copyFolderWithSelf(String oldPath, String newPath) {  
        try {  
            new File(newPath).mkdirs(); //如果文件夹不存在 则建立新文件夹  
            File dir = new File(oldPath);  
            // 目标  
            newPath +=  File.separator + dir.getName();  
            File moveDir = new File(newPath);  
            if(dir.isDirectory()){  
                if (!moveDir.exists()) {  
                    moveDir.mkdirs();  
                }  
            }  
            String[] file = dir.list();  
            File temp = null;  
            for (int i = 0; i < file.length; i++) {  
                if (oldPath.endsWith(File.separator)) {  
                    temp = new File(oldPath + file[i]);  
                } else {  
                    temp = new File(oldPath + File.separator + file[i]);  
                }  
                if (temp.isFile()) {  
                    FileInputStream input = new FileInputStream(temp);  
                    FileOutputStream output = new FileOutputStream(newPath +  
                            "/" +  
                            (temp.getName()).toString());  
                    byte[] b = new byte[1024 * 5];  
                    int len;  
                    while ((len = input.read(b)) != -1) {  
                        output.write(b, 0, len);  
                    }  
                    output.flush();  
                    output.close();  
                    input.close();  
                }  
                if (temp.isDirectory()) { //如果是子文件夹  
                    copyFolderWithSelf(oldPath + "/" + file[i], newPath);  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
	@Test
	public static void main(String arg[]) throws InterruptedException {
		Thread.sleep(10000);
		copyFolderWithSelf("C:\\Work\\AutoUserTest4x\\test-output","C:\\2016\\testlog\\log"); 
		ZipCompressorByAnt zca = new ZipCompressorByAnt(
				"C:\\2016\\testlog\\log.zip"); // 目标压缩后文件
		// compressExe("C:\\Work\\AutoUserTest\\test-output");
		zca.compressExe("C:\\2016\\testlog\\log");// 压缩目标路径

	}


}
