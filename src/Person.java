import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

	public String firstname;
	public String surname;
	public String gender;
	public String phnumber;
	public String adress;
	public String email;
	public String language;

	public void parsemail(String in) { // email
		Matcher mat;
		Pattern patt = Pattern.compile("(\\b[\\w.!#$%&’*+\\/=?^`{|}~-]+@[\\w-]+(?:\\.[\\w-]+)*\\b)");
		mat = patt.matcher(in);
		if (mat.find()) {
			this.email = mat.group(1);

		} else {
			System.out.println("Email not found");
		}
	}

	public void parseadress(String in) { // adresa
		Matcher mat;
		Pattern patt = Pattern.compile("([A-ZĚŠČŘŽÝÁÍÉŮÄÖÜß][a-zěščřžýáíéäöüẞ]+ *[0-9]{2,4}\\/[0-9]{2,3})");
		mat = patt.matcher(in);
		if (mat.find()) {
			this.adress = mat.group(1);

		} else {
			System.out.println("Adress not found");
		}
	}

	public void parsephnumber(String in) { // číslo telefonní
		Pattern p = Pattern.compile("(\\+*[0-9]{9,15})");
		Matcher mat = p.matcher(in);
		if (mat.find()) {
			this.phnumber = mat.group(1);
		} else {
			System.out.println("telephone number not found");
		}
	}

	public void parseLanguage(String in) { // jazyk
		Matcher mat;
		Pattern patt = Pattern.compile("(.*[ěščřžýáíéĚŠČŘŽÝÁÍÉŮů].*)");
		mat = patt.matcher(in);
		if (mat.find()) {
			this.language = "czech";

		} else {
			Pattern pNem = Pattern.compile("(.*[ÄäÖöÜüẞß].*)");
			mat = pNem.matcher(in);
			if (mat.find()) {
				this.language = "german";
			} else {
				this.language = "english";
			}
		}

	}

	public void parseNameandSurname(String in) { // jmeno a příjmení
		Pattern patt = Pattern.compile("([A-ZĚŠČŘŽÝÁÍÉŮ][a-zěščřžýáííéů]+) *([A-Z][a-zěščřžýáíéů]+)");
		Matcher mat = patt.matcher(in);
		if (mat.find()) {

			this.firstname = mat.group(1); // name
			this.surname = mat.group(2); // surname
		} else {
			System.out.println("Name and surname not found");
		}
	}

	public void parsegender(String in) { // pohlaví
		Matcher mat;
		Pattern patt = Pattern.compile("[Vážený pane]");
		mat = patt.matcher(in);
		if (mat.find()) {
			this.gender = "male";

		} else {
			Pattern pNem = Pattern.compile("[Vážená paní]");
			mat = pNem.matcher(in);
			if (mat.find()) {
				this.gender = "female";
			}
		} 
	}

	public String toString() {
		return "Person [firstname=" + firstname + ", surname=" + surname + ", gender=" + gender + ", phnumber="
				+ phnumber + ", adress=" + adress + ", email=" + email + ", language=" + language + "]";

	}

	public void Parse(String in) {
		parsegender(in);
		parsemail(in);
		parseadress(in);
		parseLanguage(in);
		parsephnumber(in);
		parseNameandSurname(in);
	}

}
