package org.fuelteam.watt.social.alipay;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.alipay.api.AlipayConstants;

public class AlipayUri {

    private final static String AUTHORIZE = "https://openauth.alipay%s.com/oauth2/publicAppAuthorize.htm";

    private final static String GATEWAY = "https://openapi.alipay%s.com/gateway.do";

    private final static String DEV = "dev";

    private AlipayProperties alipayProperties;

    private String env;

    public AlipayUri(AlipayProperties alipayProperties) {
        super();
        this.alipayProperties = alipayProperties;
        String env = DEV.equalsIgnoreCase(alipayProperties.getEnv()) ? DEV : "";
        this.env = env;
    }

    public String authorizeUri() {
        String encodedUri = alipayProperties.getRedirectUri();
        try {
            encodedUri = URLEncoder.encode(encodedUri, AlipayConstants.CHARSET_UTF8);
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        }
        String url = String.format(AUTHORIZE, env);
        String appId = alipayProperties.getAppId();
        String scope = alipayProperties.getScope();
        return String.format("%s?app_id=%s&scope=%s&redirect_uri=%s", url, appId, scope, encodedUri);
    }

    public String gatewayUri() {
        return String.format(GATEWAY, env);
    }
}
