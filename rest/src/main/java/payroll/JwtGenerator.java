package payroll; /***********************************************************************************************************************
 * Copyright (c) 2022. Samsung Electronics - All Rights Reserved
 * <p>
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited.
 **********************************************************************************************************************/

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtGenerator {
    private static final String PARTNER_CODE = "4051928138748138496";

    public static String produce_cdata () {

        PublicKey samsungPublicKey =
                JwtManager.readPublicKey(PayloadUtil.getStringFromFile("sample/certificate/samsungPublicKey.pem"));
        PublicKey partnerPublicKey =
                JwtManager.readPublicKey(PayloadUtil.getStringFromFile("sample/certificate/partnerPublicKey.pem"));
        PrivateKey partnerPrivateKey =
                JwtManager.readPrivateKey(PayloadUtil.getStringFromFile("sample/certificate/mySamsungPrivate.pem"));

        // Boarding pass
        String plainData = new PayloadUtil("sample/payload/BoardingPass.json").getSampleBoardingPass();

        // Coupon
        // String plainData = new PayloadUtil("sample/payload/Coupon.json").getSampleCoupon();

        // Ticket
        // String plainData = new PayloadUtil("sample/payload/Ticket.json").getSampleTicket();

        String cdata = JwtManager.generate(PARTNER_CODE, samsungPublicKey, partnerPublicKey, partnerPrivateKey, plainData);

        return cdata;
    }
}
