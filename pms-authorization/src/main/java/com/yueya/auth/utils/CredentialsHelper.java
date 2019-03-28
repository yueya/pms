package com.yueya.auth.utils;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class CredentialsHelper {
    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    /**
     * 生成随机的16位salt并经过1024次 sha-1 hash
     * @param plainCredentials
     * @return
     */
    public static String entryptCredentials(String plainCredentials) {
        ByteSource source=randomNumberGenerator.nextBytes(SALT_SIZE);
        byte[] salt = source.getBytes();
        String hashPassword = new SimpleHash(HASH_ALGORITHM,plainCredentials,salt,HASH_INTERATIONS).toHex();
        return source.toHex()+hashPassword;
    }

    /**
     * 验证密码
     * @param plainCredentials 明文密码
     * @param credentials 密文密码
     * @return 验证成功返回true
     */
    public static boolean validateCredentials(String plainCredentials, String credentials) {
        byte[] salt = Hex.decode(credentials.substring(0,16));
        ByteSource source=ByteSource.Util.bytes(salt);
        String hashPassword = new SimpleHash(HASH_ALGORITHM,plainCredentials,salt,HASH_INTERATIONS).toHex();
        return credentials.equals(source.toHex()+hashPassword);
    }

    public static void main(String[] args) {
        System.out.println(entryptCredentials("admin"));
        System.out.println(validateCredentials("admin","0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7"));
    }
}
