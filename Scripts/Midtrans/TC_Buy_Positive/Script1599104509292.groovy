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

WebUI.click(findTestObject('Midtrans/Btn_BuyNow'))

WebUI.verifyElementPresent(findTestObject('Midtrans/Ttl_ShoppingCart'), 0)

WebUI.click(findTestObject('Midtrans/Btn_CheckOut'))

WebUI.click(findTestObject('Midtrans/Btn_Continue'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Midtrans/Ttl_CreditDebitCard'))

WebUI.setText(findTestObject('Midtrans/Txt_CardNumber'), '4811111111111114')

WebUI.setText(findTestObject('Midtrans/Txt_ExpiryDate'), '0125')

WebUI.setText(findTestObject('Midtrans/Txt_CVV'), '123')

WebUI.click(findTestObject('Midtrans/Chk_Promo10persen'))

WebUI.click(findTestObject('Midtrans/Btn_PayNow'))

WebUI.delay(5)

WebUI.setText(findTestObject('Midtrans/Txt_Password'), '112233')

WebUI.click(findTestObject('Midtrans/Btn_OK'))

WebUI.delay(7)

WebUI.verifyElementPresent(findTestObject('Midtrans/Ttl_ThankYou'), 5)

