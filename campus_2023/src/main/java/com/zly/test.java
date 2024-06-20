/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2024/3/26 9:17
 */

package com.zly;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class test {
    static   String basePath = "E:\\Projects\\java\\wgcloud\\";//项目代码物理位置
    static  String txtPath = "D:\\Desktop\\";//txt存放的地址
    static  String txtName = "text";//txt名字
    static String txtEnd=".doc";//txt就用.txt
    static String txtInPath = txtPath + txtName +txtEnd;
    static  boolean txtFlag = false;//true 追加，false 重新生成txt
    public static void main(String[] args) {



        if (txtFlag) {
            File txtDir = new File(txtInPath);
            // 判断文件夹是否存在
            if (!txtDir.exists()) {
                System.out.println("文件，已重新生成");
                try {
                    creatTxtFile(txtPath, txtName);
                } catch (Exception e) {

                }
            }
        } else {
            File txtDir = new File(txtInPath);
            // 判断文件夹是否存在
            if (txtDir.exists()) {
                txtDir.delete();
            }
            try {
                creatTxtFile(txtPath, txtName);
            } catch (Exception e) {

            }
        }


        File dir = new File(basePath);

        List<File> allFileList = new ArrayList<>();

        // 判断文件夹是否存在
        if (!dir.exists()) {
            System.out.println("目录不存在");
            return;
        }
//
        getAllFile(dir, allFileList);

        for (File file : allFileList) {
            System.out.println("智能客服系统前端" + file.getAbsoluteFile() + "文件代码内容：");
            loadFile(txtInPath, "智能客服系统前端" + file.getAbsoluteFile() + "文件代码内容：\n");
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                while ((st = br.readLine()) != null){
                    loadFile(txtInPath, st);
                //       System.out.println(st);
                //  WordUtils.(filePath, st, false, 12);
                }
            } catch (Exception e) {
            }
        }

        System.out.println("=============================");
        System.out.println("该文件夹下共有" + allFileList.size() + "个文件");
    }

    public static void getAllFile(File fileInput, List<File> allFileList) {
        // 获取文件列表
        File[] fileList = fileInput.listFiles();
        assert fileList != null;
        for (File file : fileList) {
            if (file.isDirectory()) {
                // 递归处理文件夹
                // 如果不想统计子文件夹则可以将下一行注释掉
                getAllFile(file, allFileList);
            } else {
                // 如果是文件则将其加入到文件数组中
                allFileList.add(file);
            }
        }
    }

    public static void loadFile(String filePath, String line) {
        List<String> strList = new ArrayList<String>();
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file,txtFlag);
            fileWriter.write(line);
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 创建文件
     *
     * @throws IOException
     */
    public static boolean creatTxtFile(String txtPath, String txtName) throws IOException {
        boolean flag = false;
        String filenameTemp = txtPath + txtName +txtEnd;
        File filename = new File(filenameTemp);
        if (!filename.exists()) {
            filename.createNewFile();
            flag = true;
        }
        return flag;
    }

}

