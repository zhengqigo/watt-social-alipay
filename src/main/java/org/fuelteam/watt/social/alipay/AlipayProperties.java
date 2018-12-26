package org.fuelteam.watt.social.alipay;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(AlipayProperties.Prefix)
public class AlipayProperties {

    protected final static String Prefix = "spring.social.alipay";

    private String env;

    // appId or merchantId
    private String appId;

    private String scope = "auth_user";

    // RSAtool https://docs.open.alipay.com/291/105971
    // PKCS8(for Java)+2048 => Generate keys => fill <应用公钥> with 应用公钥2048.txt

    // fill <privateKey> with 应用私钥2048.txt
    private String privateKey;

    // fill <publicKey> from 支付宝公钥
    private String publicKey;

    private String signType;

    private String redirectUri;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }
}
