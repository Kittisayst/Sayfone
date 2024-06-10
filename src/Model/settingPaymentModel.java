package Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class settingPaymentModel {

    int overpayValue;
    int[] discountValue;

    public settingPaymentModel(int overpayValue, int[] discountValue) {
        this.overpayValue = overpayValue;
        this.discountValue = discountValue;
    }

    public static settingPaymentModel toAttay(String value) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object[] array = objectMapper.readValue(value, Object[].class);
            return new settingPaymentModel((int) array[0], objectMapper.convertValue(array[1], int[].class));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(settingPaymentModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int getOverpayValue() {
        return overpayValue;
    }

    public void setOverpayValue(int overpayValue) {
        this.overpayValue = overpayValue;
    }

    public void setOverpayState(boolean state) {
        this.overpayValue = state ? 1 : 0;
    }

    public int[] getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(int[] discountValue) {
        this.discountValue = discountValue;
    }

    public void setDisCountState(boolean state) {
        this.discountValue[0] = state ? 1 : 0;
    }

    public void setMoney(int Money) {
        this.discountValue[1] = Money;
    }

    public boolean isOverpary() {
        return overpayValue == 1;
    }

    public boolean isDiscount() {
        return discountValue[0] == 1;
    }

    public int getMoney() {
        return discountValue[1];
    }

    public String createValue() {
        return "[" + overpayValue + ", " + Arrays.toString(discountValue) + "]";
    }

    @Override
    public String toString() {
        return "settingPaymentModel{" + "overpayValue=" + overpayValue + ", discountValue=" + Arrays.toString(discountValue) + '}';
    }
}
