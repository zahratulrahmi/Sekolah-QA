import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

WebUI.click(findTestObject('Midtrans/Btn_BuyNow'))

WebUI.verifyElementPresent(findTestObject('Midtrans/Ttl_ShoppingCart'), 0)

def datasetMidtrans = findTestData('Data Files/Midtrans Shopping Cart')

for (def rowMidtrans = 1; rowMidtrans <= datasetMidtrans.getRowNumbers() ; rowMidtrans++) {
    WebUI.setText(findTestObject('Midtrans/Txt_Name'), datasetMidtrans.getValue('name', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_Email'), datasetMidtrans.getValue('email', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_PhoneNo'), datasetMidtrans.getValue('phone_no', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_City'), datasetMidtrans.getValue('city', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_Address'), datasetMidtrans.getValue('address', rowMidtrans))

    WebUI.setText(findTestObject('Midtrans/Txt_PostalCode'), datasetMidtrans.getValue('postal_code', rowMidtrans))

    WebUI.click(findTestObject('Midtrans/Btn_CheckOut'))

    if (WebUI.verifyElementPresent(findTestObject('Midtrans/Ttl_CocoStore'), 2, FailureHandling.OPTIONAL) == true) {
		
		WebUI.click(findTestObject('Midtrans/Icn_Close'))
		
		println("Failed")
		
	} else {
		
		WebUI.verifyMatch(WebUI.getText(findTestObject('Midtrans/Ttl_Midtranspillow')), datasetMidtrans.getValue('expected_result', rowMidtrans), false) 
		
		println("Passed")
	}
		
    WebUI.delay(3)

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

WebUI.delay(5)

WebUI.click(findTestObject('Midtrans/Btn_Cancel'))

WebUI.delay(5)

