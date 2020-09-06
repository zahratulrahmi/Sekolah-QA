import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.click(findTestObject('Slack/Lnk_Signin'))

WebUI.verifyElementPresent(findTestObject('Slack/Ttl_Signin'), 0)

println('Url yang exist adalah: ' + WebUI.getUrl())

WebUI.verifyMatch(WebUI.getUrl(), 'https://slack.com/signin', false)

WebUI.setText(findTestObject('Slack/Txt_Workspace'), 'sekolahqa4')

WebUI.click(findTestObject('Slack/Btn_Continue'))



def datasetLogin = findTestData('Data Files/Login Slack')

for (def rowLogin = 1; rowLogin <= datasetLogin.getRowNumbers(); rowLogin++) {
    WebUI.setText(findTestObject('Slack/Txt_Email'), datasetLogin.getValue('username', rowLogin))

    WebUI.setText(findTestObject('Slack/Txt_Password'), datasetLogin.getValue('password', rowLogin))

    WebUI.click(findTestObject('Slack/Btn_Signin'))

	def actualWarning = WebUI.getText(findTestObject('Slack/Ttl_Signin_SekolahQA'))
    
	WebUI.verifyMatch(actualWarning, datasetLogin.getValue('Expected_Result', rowLogin), false)
	
	WebUI.sendKeys(findTestObject('Slack/Txt_Email'), Keys.chord(Keys.CONTROL, 'a'))
	
	WebUI.sendKeys(findTestObject('Slack/Txt_Email'), Keys.chord(Keys.BACK_SPACE))
	
	WebUI.sendKeys(findTestObject('Slack/Txt_Password'), Keys.chord(Keys.CONTROL, 'a'))
	
	WebUI.sendKeys(findTestObject('Slack/Txt_Password'), Keys.chord(Keys.BACK_SPACE))
}

