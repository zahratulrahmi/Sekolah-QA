import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.click(findTestObject('Midtrans/Btn_BuyNow'))

WebUI.verifyElementPresent(findTestObject('Midtrans/Ttl_ShoppingCart'), 0)

def datasetMidtrans = findTestData('Data Files/Midtrans Shopping Cart')

for (def rowMidtrans = 1; rowMidtrans <= 2; rowMidtrans++) {
    WebUI.setText(findTestObject('Midtrans/Txt_Name'), datasetMidtrans.getValue('name', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_Email'), datasetMidtrans.getValue('email', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_PhoneNo'), datasetMidtrans.getValue('phone_no', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_City'), datasetMidtrans.getValue('city', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_Address'), datasetMidtrans.getValue('address', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_PostalCode'), datasetMidtrans.getValue('postal_code', rowMidtrans))

    WebUI.click(findTestObject('Midtrans/Btn_CheckOut'))

    def actualWarning = WebUI.getText(findTestObject('Midtrans/Ttl_Midtranspillow'))

    WebUI.verifyMatch(actualWarning, datasetMidtrans.getValue('expected_result', rowMidtrans), false)

    //actualWarning2 = WebUI.getText(findTestObject('Midtrans/Icn_Close'))
    //    if (WebUI.verifyElementPresent(findTestObject('Midtrans/Ttl_Midtranspillow'), FailureHandling.OPTIONAL) ) {
    //		println("data salah")
    //		WebUI.verifyMatch(actualWarning, datasetMidtrans.getValue('expected_result', rowLogin), false)
    //		//WebUI.click(findTestObject('Midtrans/Icn_Close'))
    //    } 
    //	else {
    //if ((WebUI.getText(findTestObject('Midtrans/Icn_Close'))) != datasetLogin.getValue('expected_result', rowLogin)) {
    //	WebUI.verifyElementNotPresent(findTestObject('Midtrans/Ttl_Midtranspillow'), 0)
    //WebUI.verifyElementPresent(findTestObject('Midtrans/Ttl_Midtranspillow'), 0)
    //		WebUI.click(findTestObject('Midtrans/Icn_Close'))
    //    }
    //    def actualWarning = WebUI.getText(findTestObject('Midtrans/Ttl_Midtranspillow'))
    //
    //    WebUI.verifyMatch(actualWarning, datasetLogin.getValue('expected_result', rowLogin), true)
    WebUI.delay(2)

    WebUI.click(findTestObject('Midtrans/Btn_BuyNow'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_Name'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_Name'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_Email'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_Email'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_PhoneNo'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_PhoneNo'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_City'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_City'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_Address'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_Address'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_PostalCode'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_PostalCode'), Keys.chord(Keys.BACK_SPACE))
}

WebUI.delay(2)

for (def rowMidtrans = 3; rowMidtrans <= datasetMidtrans.getRowNumbers(); rowMidtrans++) {
    WebUI.setText(findTestObject('Midtrans/Txt_Name'), datasetMidtrans.getValue('name', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_Email'), datasetMidtrans.getValue('email', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_PhoneNo'), datasetMidtrans.getValue('phone_no', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_City'), datasetMidtrans.getValue('city', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_Address'), datasetMidtrans.getValue('address', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_PostalCode'), datasetMidtrans.getValue('postal_code', rowMidtrans))

    WebUI.click(findTestObject('Midtrans/Btn_CheckOut'))

    def actualWarning = WebUI.getText(findTestObject('Midtrans/Ttl_OrderSummary'))

    WebUI.verifyNotMatch(actualWarning, datasetMidtrans.getValue('expected_result', rowMidtrans), false)

    WebUI.click(findTestObject('Midtrans/Icn_Close'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Midtrans/Btn_BuyNow'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_Name'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_Name'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_Email'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_Email'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_PhoneNo'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_PhoneNo'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_City'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_City'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_Address'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_Address'), Keys.chord(Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_PostalCode'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('Midtrans/Txt_PostalCode'), Keys.chord(Keys.BACK_SPACE))
}

WebUI.click(findTestObject('Midtrans/Btn_Cancel'))

WebUI.delay(5)

