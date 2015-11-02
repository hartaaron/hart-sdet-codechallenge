/**
 * Created by benjarman on 8/11/15.
 */
import ca.uhn.hl7v2.DefaultHapiContext
import ca.uhn.hl7v2.model.v24.message.ADT_A01
import org.json4s.jackson.JsonMethods._
import org.json4s.jackson.Serialization.write
import org.json4s.DefaultFormats

object Test extends App{

  implicit val format = DefaultFormats;

  /* v24 comes from the 2.4 on the first line there */
  val testdata = """MSH|^~\&|LAB|SFM|FA-8.9|7431|20150116011000||ORU^R01|3209115.1|P|2.5.1
PID|1|SOCL0076876|FM02253716^^^^MR~618-03-0473^^^^SS~FM250109^^^^PI~SOCL0076876^^^^HUB||MARTINEZ^DERLY^R||19830410|M||OT|1060 BONNIE ANN COURT^^LA HABRA^CA^90631||562-691-9631|||M|CAT|FV0083480971||||
ROL|1|AD|FHCP|
ROL|2|AD|PP|NONE^None^^^^^^PRV~1558575746^None^^^^^^NPI
PV1|1|E|SFMED|ER|||LARCH002^Larsen^Cheryl^^^^^PRV~1538324397^Larsen^Cheryl^^^^^NPI|||||||HOME||N^V~^C||ER||XN|||||||||||||||||||SFM||REG|||201501152318|
OBR|1|0116:U00026S^MEDITECH|0116:U00026S^LAB|57020-0^^LN^UAUMICrx^Urinalysis w/ Microsc Rflx^LB||201501152329|201501160101|||||||201501160101||1073605473||||||201501160110||URIN^Urinalysis|F||^^^^^R|LARCH002^Larsen^Cheryl^^^^^PRV~1538324397^Larsen^Cheryl^^^^^NPI||||
TQ1|||||||||S
SPM|1|01411078^2021908^LAB|0116:U00026S^2021908^LAB^011615:U26||||||||||||||201501160101|201501160101|||||||||
SAC|||0116:U00026S^2021908^LAB^011615:U26
OBX|1|ST|5778-6^^LN^.COLU^Urine Color^LB|1|Amber||Yellow|N|||F|||201501160109|SFML^SFM Main Laboratory^L
OBX|2|ST|32167-9^^LN^.CLU^Urine Clarity^LB|1|Cloudy||Clear|N|||F|||201501160109|SFML^SFM Main Laboratory^L
OBX|3|ST|5811-5^^LN^SPGRU^Urine Specific Gravity^LB|1|1.018||1.003-1.035|N|||F|||201501160109|SFML^SFM Main Laboratory^L
OBX|4|ST|2756-5^^LN^PHU^Urine pH^LB|1|7.0||5.0-8.0|N|||F|||201501160109|SFML^SFM Main Laboratory^L
OBX|5|ST|5804-0^^LN^.PROTU^Urine Protein^LB|1|100||<30| H|||F|||201501160109|SFML^SFM Main Laboratory^L
OBX|6|ST|5792-7^^LN^.GLUU^Urine Glucose^LB|1|500|mg/dL|Negative| H|||F|||201501160109|SFML^SFM Main Laboratory^L
OBX|7|ST|49779-2^^LN^.KETU^Urine Ketones^LB|1|Negative||Neg - Trace|N|||F|||201501160109|SFML^SFM Main Laboratory^L
OBX|8|ST|5770-3^^LN^.BILIU^Urine Bilirubin^LB|1|Negative||Negative|N|||F|||201501160109|SFML^SFM Main Laboratory^L
OBX|9|ST|33051-4^^LN^.BLDU^Urine Blood^LB|1|Small||Neg - Trace| H|||F|||201501160110|SFML^SFM Main Laboratory^L
OBX|10|ST|32710-6^^LN^.NITR^Urine Nitrite^LB|1|Negative||Negative|N|||F|||201501160109|SFML^SFM Main Laboratory^L
OBX|11|ST|13658-0^^LN^.URBILUR^Urine Urobilinogen^LB|1|0.2||<2.0|N|||F|||201501160109|SFML^SFM Main Laboratory^L
OBX|12|ST|32782-5^^LN^.LEUE^Urine Leukocyte Esterase^LB|1|Negative||Neg - Trace|N|||F|||201501160109|SFML^SFM Main Laboratory^L
OBX|13|ST|5767-9^^LN^.SPDESCR^UA Specimen Description^LB|1|Clean Catch Midstrea|||N|||F|||201501160103|SFML^SFM Main Laboratory^L
OBX|14|ST|12235-8^^LN^.MICRFLX^Reflex Microscopic^LB|1|Microscopic Reflexed|||N|||F|||201501160109|SFML^SFM Main Laboratory^L
OBX|15|ST|58449-0^^LN^.RBCUR^Urine RBC's^LB|1|98|/HPF|0-3| H|||F|||201501160110|SFML^SFM Main Laboratory^L
OBX|16|ST|46702-7^^LN^.WBCURN^Urine WBC's^LB|1|1|/HPF|0-5|N|||F|||201501160110|SFML^SFM Main Laboratory^L
OBX|17|ST|44038-8^^LN^.BACTU^Urine Bacteria^LB|1|None||None|N|||F|||201501160110|SFML^SFM Main Laboratory^L
OBX|18|ST|630-4^^LN^.ADDCU^Add Urine Culture^LB|1|N|||N|||F|||201501160110|SFML^SFM Main Laboratory^L
OBX|19|ST|630-4^^LN^.ORDCULTU^Order Urine Culture^LB|1|Not Indicated|||N|||F|||201501160110|SFML^SFM Main Laboratory^L
ZPS|1|SFML|SFM Main Laboratory|101 E. Valencia Mesa Dr^^Fullerton^CA^92835|Dr. Victor W Lee, MD|CLIA#05D0576873|"""

  println(com.hart.HL7.Parser(testdata).getJsonString())
  /*println(testdata)
  val context = new DefaultHapiContext()
  val p = context.getGenericParser()
  val fact = p.getFactory()
  println(fact.getMessageClass("ADT", "A01", true))
  val msg = p.parse(testdata)
  val adta13 = msg.asInstanceOf[ADT_A01]
  adta13
  val json = write(adta13)
  println(json);*/

}
