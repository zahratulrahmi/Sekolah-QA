import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Midtrans/Btn_BuyNow'))

WebUI.verifyElementPresent(findTestObject('Midtrans/Ttl_ShoppingCart'), 0)

WebUI.setText(findTestObject('Midtrans/Txt_Name'), 'Budi')

WebUI.setText(findTestObject('Midtrans/Txt_Email'), 'budi@utomo.com')

WebUI.setText(findTestObject('Midtrans/Txt_PhoneNo'), '081808466410')

WebUI.setText(findTestObject('Midtrans/Txt_City'), 'Jakarta')

WebUI.setText(findTestObject('Midtrans/Txt_Address'), 'MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11')

WebUI.setText(findTestObject('Midtrans/Txt_PostalCode'), '10220')

WebUI.click(findTestObject('Midtrans/Btn_CheckOut'))

WebUI.click(findTestObject('Midtrans/Btn_Continue'))

WebUI.click(findTestObject('Midtrans/Ttl_CreditDebitCard'))

def datasetMidtrans2 = findTestData('Data Files/Midtrans Credit Card')

for (def rowMidtrans2 = 1; rowMidtrans2 <= datasetMidtrans2.getRowNumbers(); rowMidtrans2++) {
    
	WebUI.setText(findTestObject('Midtrans/Txt_CardNumber'), datasetMidtrans2.getValue('card_number', rowMidtrans2))

    WebUI.setText(findTestObject('Midtrans/Txt_ExpiryDate'), datasetMidtrans2.getValue('expiry_date', rowMidtrans2))

    WebUI.setText(findTestObject('Midtrans/Txt_CVV'), datasetMidtrans2.getValue('cvv', rowMidtrans2))

    WebUI.click(findTestObject('Midtrans/Btn_PayNow'))

    def actualWarning = WebUI.getText(findTestObject('Midtrans/Ttl_Amount'))

    if (WebUI.verifyElementPresent(findTestObject('Midtrans/Btn_Cancel2'), 2, FailureHandling.OPTIONAL) == true ) {
				
		WebUI.click(findTestObject('Midtrans/Btn_Cancel2'))
		
		println("Failed")
		
    } else {
				
		WebUI.verifyMatch(actualWarning, datasetMidtrans2.getValue('expected_result', rowMidtrans2), false)
		
		println("Passed")
		
		WebUI.sendKeys(findTestObject('Midtrans/Txt_CardNumber'), Keys.chord(Keys.CONTROL, 'a'))
		
		WebUI.sendKeys(findTestObject('Midtrans/Txt_CardNumber'), Keys.chord(Keys.BACK_SPACE))
		
		WebUI.sendKeys(findTestObject('Midtrans/Txt_ExpiryDate'), Keys.chord(Keys.CONTROL, 'a'))
		
		WebUI.sendKeys(findTestObject('Midtrans/Txt_ExpiryDate'), Keys.chord(Keys.BACK_SPACE))
		
		WebUI.sendKeys(findTestObject('Midtrans/Txt_CVV'), Keys.chord(Keys.CONTROL, 'a'))
		
		WebUI.sendKeys(findTestObject('Midtrans/Txt_CVV'), Keys.chord(Keys.BACK_SPACE))
    }

}

WebUI.delay(5)

WebUI.closeBrowser()

