package my.utm.ip.demo.mvc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import my.utm.ip.demo.mvc.models.User;
import my.utm.ip.demo.mvc.models.News;
import my.utm.ip.demo.mvc.models.ToDoItems;

public class MockDatabase {

	public static ArrayList<User> users = new ArrayList<User>();

	static {
		users.add(new User("John Doe", "user1", "pwd"));
		users.add(new User("Jane Die", "user9", "pwd"));
	}

	public static ArrayList<News> news = new ArrayList<News>();
	public static ArrayList<ToDoItems> toDoItems = new ArrayList<ToDoItems>();

	static {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");


			try {
				 toDoItems.add(new ToDoItems(1, 1, "Work", "Complete project report", "#3498db", timeFormat.parse("15:00:00")));
		         toDoItems.add(new ToDoItems(2, 1, "Personal", "Go for a run", "#2ecc71", timeFormat.parse("15:00:00")));
		         toDoItems.add(new ToDoItems(3, 2, "Study", "Read chapter 5", "#e74c3c", timeFormat.parse("15:00:00")));

			news.add(new News(1, "Stop thinking of toppling govt, we broke green wave by winning Selangor, Gobind tells PN", "SHAH ALAM: Pakatan Harapan halted the \"green wave\" of Perikatan Nasional when the former won the Selangor state election, said Selangor DAP chairman Gobind Singh Deo.\r\n" + 
					
					"The Damansara MP said that this was despite Perikatan�s boast that it would win five states including Selangor, in the recent six state elections in Kelantan, Terengganu, Selangor, Kedah, Penang and Negri Sembilan held in August.\n\"The opposition thinks that there is a �wave� to raise them. They think that there is a possibility of government change within the next five years.\r\n" + 
					
					"�I tell them that there is no such possibility for the next five years,\" said Gobind in his opening speech at the Selangor DAP annual convention 2023 held here on Sunday (Nov 26).\r\n" + 
					"He was alluding to the term \"green wave\" which has been used to signify the rise of the Malay votes for Perikatan in the last general election and state elections.\r\n" + 
					
					"Perikatan leaders have also stated recently at PAS and Bersatu annual general meetings on the likelihood of a government change before the current electoral term is up.\r\n" + 
					
					"He further pointed out that the current Unity Government under Prime Minister Datuk Seri Anwar Ibrahim is a stable one with strong cooperation from all of its component parties.\r\n" + 
					"With Barisan Nasional, the cooperation is strong and we can now focus on economic recovery.", dateFormat.parse("2023-11-27"), "T1.jpeg", "The Star Online", "ZAKIAH KOYA "));
			
		      news.add(new News(2, "Couple buy studio flat for domestic helper in India to show gratitude", "SINGAPORE: To show their appreciation and gratitude to their helper Rana Mamta, Joseph Harison and his wife Leens Joseph bought her a studio flat in her home town of Darjeeling, India, in 2021.\r\n" + 
					"\r\n" + 
					"The couple, who have two children aged 14 and eight, had hired Mamta in 2015 during a time of need.", dateFormat.parse("2023-10-29"), "T2.jpg", "SINGAPORE", " "));
			
			
			news.add(new News(3, "POSITIVE IMPACT ON LIVES AND THE ENVIRONMENT", "THE Star Golden Hearts Award (SGHA) and Gamuda Inspiration Award (GIA) � collaborations between The Star Foundation and Yayasan Gamuda � recognise outstanding individuals or groups for their exceptional contributions across several realms, including supporting indigenous communities, raising awareness and funds for autism, contributing to wildlife conservation, providing education to underprivileged students, and other impactful initiatives.\r\n" + 
					"\r\n" + 
					"SGHA annually honours 10 outstanding winners, while the GIA is awarded to at least one exceptional social changemaker among the 10 winners, with an additional grant from Yayasan Gamuda to further propel their efforts.", dateFormat.parse("2023-11-25"), "T3.jpg", "STARPICKS", "ANN MARIE CHANDY"));
			news.add(new News(4, "Jack Ma gets back into business with 'Ma's Kitchen Food�", "Jack Ma sparked speculation about his next endeavours after the billionaire seeded a small company to process and sell farming produce, in his latest venture since retreating from the spotlight at the height of a government-led industry crackdown.\r\n" + 
					"\r\n" + 
					"The co-founder of Alibaba Group Holding Ltd set up �Hangzhou Ma�s Kitchen Food� last week with an initial registered capital of 10mil yuan (RM6.54mil), according to corporate database Tianyancha. The business involves the sale of packaged agricultural products, according to information on China�s National Enterprise Credit Information Publicity System.", dateFormat.parse("2023-11-27"), "T4.jpeg", "INTERNET", "JANE ZHANG"));
			news.add(new News(5, "Court document claims Meta knowingly designed its platforms to hook kids, reports say", "SAN FRANCISCO: Facebook parent Meta Platforms deliberately engineered its social platforms to hook kids and knew � but never disclosed � it had received millions of complaints about underage users on Instagram but only disabled a fraction of those accounts, according to a newly unsealed legal complaint described in reports from The Wall Street Journal and The New York Times.The complaint, originally made public in redacted form, was the opening salvo in a lawsuit filed in late October by the attorneys general of 33 states.", dateFormat.parse("2023-11-27"), "T5.jpg", "SOCIAL MEDIA", " "));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}