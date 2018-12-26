package org.fuelteam.watt.social.alipay.autoconfigurer;

import java.util.Objects;

import org.fuelteam.watt.social.alipay.AlipayProperties;
import org.fuelteam.watt.social.alipay.AlipayUri;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;

@Configuration
@EnableConfigurationProperties(AlipayProperties.class)
public class AlipayAutoConfiguration {

    private static final String MSG_APPID_NULL = "appId can not be null";

    private static final String MSG_PRIVATE_KEY_NULL = "privateKey can not be null";

    private static final String MSG_PUBLIC_KEY_NULL = "publicKey can not be null";

    @Bean
    public AlipayClient alipayClient(AlipayProperties alipayProperties) {
        String gatewayUri = new AlipayUri(alipayProperties).gatewayUri();

        String appId = Objects.requireNonNull(alipayProperties.getAppId(), MSG_APPID_NULL);
        String privateKey = Objects.requireNonNull(alipayProperties.getPrivateKey(), MSG_PRIVATE_KEY_NULL);
        String format = AlipayConstants.FORMAT_JSON;
        String charset = AlipayConstants.CHARSET_UTF8;
        String publicKey = Objects.requireNonNull(alipayProperties.getPublicKey(), MSG_PUBLIC_KEY_NULL);
        String RSA = AlipayConstants.SIGN_TYPE_RSA;
        String RSA2 = AlipayConstants.SIGN_TYPE_RSA2;
        String signType = RSA.equals(alipayProperties.getSignType()) ? RSA : RSA2;

        return new DefaultAlipayClient(gatewayUri, appId, privateKey, format, charset, publicKey, signType);
    }

    @Bean
    public AlipayUri AlipayUri(AlipayProperties alipayProperties) {
        return new AlipayUri(alipayProperties);
    }
}
