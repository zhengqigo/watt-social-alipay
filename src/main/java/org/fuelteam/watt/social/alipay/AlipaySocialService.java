package org.fuelteam.watt.social.alipay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;

@Component
public class AlipaySocialService {

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private AlipayUri alipayUri;

    public String authorizeUri() {
        return alipayUri.authorizeUri();
    }

    public AlipaySocialUser user(HttpServletRequest request, HttpServletResponse response) {
        String authCode = request.getParameter("auth_code");
        if (StringUtils.isEmpty(authCode)) return null;
        AlipayUserInfoShareResponse shareResp = null;
        try {
            String accessToken = accessToken(authCode);
            if (StringUtils.isEmpty(accessToken)) return null;
            shareResp = shareResp(accessToken);
        } catch (AlipayApiException aae) {
            aae.printStackTrace();
        }
        if (shareResp == null) return null;
        return copy(shareResp);
    }

    private AlipaySocialUser copy(AlipayUserInfoShareResponse shareResp) {
        AlipaySocialUser alipayUser = new AlipaySocialUser();
        alipayUser.setAddress(shareResp.getAddress());
        alipayUser.setArea(shareResp.getArea());
        alipayUser.setAvatar(shareResp.getAvatar());
        alipayUser.setCertified(shareResp.getIsCertified());
        alipayUser.setCertNo(shareResp.getCertNo());
        alipayUser.setCertType(shareResp.getCertType());
        alipayUser.setCity(shareResp.getCity());
        alipayUser.setCollegeName(shareResp.getCollegeName());
        alipayUser.setDegree(shareResp.getDegree());
        alipayUser.setEmail(shareResp.getEmail());
        alipayUser.setGender(shareResp.getGender());
        alipayUser.setMobile(shareResp.getMobile());
        alipayUser.setNickName(shareResp.getNickName());
        alipayUser.setProvince(shareResp.getProvince());
        alipayUser.setStudent(shareResp.getIsStudentCertified());
        alipayUser.setUserId(shareResp.getUserId());
        alipayUser.setUserName(shareResp.getUserName());
        alipayUser.setUserStatus(shareResp.getUserStatus());
        alipayUser.setUserType(shareResp.getUserType());
        return alipayUser;
    }

    private String accessToken(String authCode) throws AlipayApiException {
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setCode(authCode);
        request.setGrantType("authorization_code");
        AlipaySystemOauthTokenResponse response = alipayClient.execute(request);
        if (response == null) return null;
        return response.getAccessToken();
    }

    private AlipayUserInfoShareResponse shareResp(String token) throws AlipayApiException {
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        AlipayUserInfoShareResponse response = alipayClient.execute(request, token);
        if (response.isSuccess()) return response;
        System.out.println(String.format("failed %s(%s)", response.getSubMsg(), response.getSubCode()));
        return null;
    }
}
