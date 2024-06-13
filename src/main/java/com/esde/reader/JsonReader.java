package com.esde.reader;

import com.esde.exception.FileParsingException;
import com.esde.model.PayPalPayment;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    public List<PayPalPayment> readFromJsonFile(String filename) throws FileParsingException {
        List<PayPalPayment> payPalPayments = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(filename));
            for (JsonNode node : rootNode) {
                String paymentInfo = node.get("paymentInfo").asText();

                PayPalPayment payPalPayment = new PayPalPayment(paymentInfo);
                payPalPayments.add(payPalPayment);
            }
        } catch (IOException e) {
            throw new FileParsingException(e);
        }

        return payPalPayments;
    }
}