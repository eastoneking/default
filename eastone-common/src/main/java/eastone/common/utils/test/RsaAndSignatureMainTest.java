/*
 * create:2015年12月5日 下午11:42:15
 * author:wangds  
 */
package eastone.common.utils.test;

import java.security.KeyPair;

import org.apache.commons.codec.binary.Base64;

import eastone.common.utils.RsaEncryptUtil;
import eastone.common.utils.RsaSignatureUtil;


public class RsaAndSignatureMainTest {

    public static void _main(String[] args) throws Exception {
        String filepath="G:/tmp/";

        //RSAEncrypt.genKeyPair(filepath);
        
        
        System.out.println("--------------公钥加密私钥解密过程-------------------");
        String plainText="ihep_公钥加密私钥解密";
        //公钥加密过程
        byte[] cipherData=RsaEncryptUtil.encrypt(RsaEncryptUtil.loadPublicKeyByStr(RsaEncryptUtil.loadPublicKeyByFile(filepath)),plainText.getBytes());
        String cipher=Base64.encodeBase64String(cipherData);
        //私钥解密过程
        byte[] res=RsaEncryptUtil.decrypt(RsaEncryptUtil.loadPrivateKeyByStr(RsaEncryptUtil.loadPrivateKeyByFile(filepath)), Base64.decodeBase64(cipher));
        String restr=new String(res);
        System.out.println("原文："+plainText);
        System.out.println("加密："+cipher);
        System.out.println("解密："+restr);
        System.out.println();
        
        System.out.println("--------------私钥加密公钥解密过程-------------------");
        plainText="ihep_私钥加密公钥解密";
        //私钥加密过程
        cipherData=RsaEncryptUtil.encrypt(RsaEncryptUtil.loadPrivateKeyByStr(RsaEncryptUtil.loadPrivateKeyByFile(filepath)),plainText.getBytes());
        cipher=Base64.encodeBase64String(cipherData);
        //公钥解密过程
        res=RsaEncryptUtil.decrypt(RsaEncryptUtil.loadPublicKeyByStr(RsaEncryptUtil.loadPublicKeyByFile(filepath)), Base64.decodeBase64(cipher));
        restr=new String(res);
        System.out.println("原文："+plainText);
        System.out.println("加密："+cipher);
        System.out.println("解密："+restr);
        System.out.println();
        
        System.out.println("---------------私钥签名过程------------------");
        String content="这是用于签名的原始数据";
        String signstr=RsaSignatureUtil.sign(content,RsaEncryptUtil.loadPrivateKeyByFile(filepath));
        System.out.println("签名原串："+content);
        System.out.println("签名串："+signstr);
        System.out.println();
        
        System.out.println("---------------公钥校验签名------------------");
        System.out.println("签名原串："+content);
        System.out.println("签名串："+signstr);
        
        System.out.println("验签结果："+RsaSignatureUtil.doCheck(content, signstr, RsaEncryptUtil.loadPublicKeyByFile(filepath)));
        System.out.println();
        
    }
    
    public static void main(String[] args) {
        KeyPair kp = RsaEncryptUtil.genKeyPair();
        String content="这是用于签名的原始数据";
        String signstr=RsaSignatureUtil.sign(content,RsaEncryptUtil.key2String(RsaEncryptUtil.getPrivateKey(kp)));
        System.out.println(signstr);
        System.out.println(RsaSignatureUtil.doCheck(content, signstr, RsaEncryptUtil.key2String(RsaEncryptUtil.getPublicKey(kp))));
        
    }
}

