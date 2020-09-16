package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id ="2016101200668218";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCvc8+P1PumvERVdzxH+2eLaK4D4edNN5UsEZCu2doeYDmHhKBb1uz0PObxtxHaSgA86qH0gmjCX4CauiJeYgVIAo7oteOYHbnCE/lmIifYLTfvXISe2pL/kPbVNACV6Y6u8b2HiTGwzFeToZPuTtkDXWIAxgcr7k+xmsr4HOm36LHqPJz3nNbxSnWBG9JFWm8ZZ+33NjbkSBTVIiAQDl4iOUnfB1U0sIb/sTMY8FW+EGkHT597xv8Ak+/FZ1HE1120STjmVAJYZb7SBMBIqGQ4de6W6x7YbYNBT3uHVf5+zEPuwuGa6PI38nnJt0ycNI/XgIoVP73gfhjwI9n7WICnAgMBAAECggEBAKElTFF9u/jDWDvrPMmcRdkMNy/Hr6sDTxZft7Rw0N4vYQdwL9zKRW559V+y1knYx+krU78Ae/lyv+rc5K4td05RUzK3xKc1PiTcNaex3Ui3F3XYUtKYTIVAfwUJMzR9hJh33az7vFD3DcTBld4+OyHVBitRtsqJolaspplF7QAEym8f7Y8GZ0KNhum0nNQU7wn/OemsutN8ln1LYDFoMizJ2a08TL6Tq1pygOLFuYqy07gJK1QcQeQsX98z4bLA+C2UR0QZRociyPc+vbrdEaC7R+6plJrjAt3UkOvozq3eIwbndBnERvnDbokxNPQ66+u7y9C5FczZUkq5/hlaOCkCgYEA34nOZ1A51kQR10xNXulvLG5I4LtxqMQL/wYoM3I6gWgZX+tLN3SLYEcUKCa6L00bpNt7EmIsmNB+PaSeJ9bmV2S+8rr7Tjbo3oxPrTLGWM9X8Y3bbNJ2ExQ8ojAhPDji+pNYGcTXARy7J/7iLkGj5YzdDbflZs6EAljvAhgZ0ZsCgYEAyO5gayKmtGh0nf0Gu3ybw1nxg+40Ds6+6DrQyHeQ6doRmKoWAeX1/pOjevkOZWrraG9UdDTCnHRAH5fdv6hKsM5r+frPIkXcvOmvy/S6QXviziesEFXmGHaRURx5N3lZASMQIND17JtCTtV2OJfEHxaqANfNEQLU3ZIWv/rsk+UCgYAHJHIR3wBaFkazqF54f+DrfIKbm6GgENOJTHsQWcAAzoCxDeWTWgfyBZNhTQt5427Ur6aZCcX/A/pkodPj1fv6It/vBYZuE1cRdU4+bHbl84oNz8iJC5h2N5lQXVVShUbLVtXjzORJxs88EerMK5C/DucpPwz3YfXZ1VmdqYN5rQKBgQCgchjz89uCO9bDQYTauYn32B6O5usS1+yBrFWDflZtJgDfExI3udVQz7u/OplQSqxn3F5n3Kl6HSoHEFG19UCPJoX6O1ijWX4GK+SAzI7eM3rMe8ld0fnGlwc66a2xqmh0C/eY/MMjiGbOZI3eavHkkUh3G9tYNhacR0d7TXcUMQKBgHnMeYs69IHCKOR3Fjo8tYupWA1rwULnwiUYcFq1jkNBO6ISS+HCoZxe424R2QnbvbEWkx8kCN1U8KTIlXB498LVQlmsT3+HXcYv0wLHWeTfOGIrciCg2n5u/k6PG1u6esFKh2I0BYyEt4Z/vGH4KaoLuGh9JE/9AZde4DWtaL1T";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhsSDZH9lHgTfCCNCoaPlQa87CRugfwgmNOZwpI2YAOAg0F8paMgldvEnqvdet1W7ZhlLLTEhuk/wGq0i86628ptcUtjAjUF1HawsXvVaA0lO77+kZk8D4PDzne+lksYD/Q4AhrWnE3SmkIB9ueML47mqfo4s7jQBprlgzsT0CcI5eCKbU4WH//DL9YpSEhEvThZKX9GVjAhjdog0/W7Z3Gjw/7FYjnwv+UvNAxSaOL5Ly/AGIWMTyb2QwKxJvRqayzloaQAbgZRd9mopo5vRXJmCiKhLIhyXY302vDyPNclXRPCqoh9f4JYG7Icfg2qLwMn/KQANA4zNxTymlnu9JwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost/dayFresh/user.jsp?pay=ok";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

