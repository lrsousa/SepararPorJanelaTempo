package ic.model;

public class CodEvento {
	public int getCode(String evento) {
		switch(evento) {
			case "assignment upload" : return 1;
			case "assignment view" : return 2;
			case "assignment view all" : return 3;
			case "blog view" : return 4;
			case "chat report" : return 5;
			case "chat talk" : return 6;
			case "chat view" : return 7;
			case "chat view all" : return 8;
			case "choice choose" : return 9;
			case "choice choose again" : return 10;
			case "choice view" : return 11;
			case "choice view all" : return 12;
			case "course user report" : return 13;
			case "course view" : return 14;
			case "discussion mark read" : return 15;
			case "forum add discussion" : return 16;
			case "forum add post" : return 17;
			case "forum delete discussion" : return 18;
			case "forum delete post" : return 19;
			case "forum mail error" : return 20;
			case "forum mark read" : return 21;
			case "forum search" : return 22;
			case "forum stop tracking" : return 23;
			case "forum subscribe" : return 24;
			case "forum subscribeall" : return 25;
			case "forum unsubscribe" : return 26;
			case "forum unsubscribeall" : return 27;
			case "forum update post" : return 28;
			case "forum user report" : return 29;
			case "forum view discussion" : return 30;
			case "forum view forum" : return 31;
			case "forum view forums" : return 32;
			case "quiz attempt" : return 33;
			case "quiz close attempt" : return 34;
			case "quiz continue attemp" : return 36;
			case "quiz continue attempt" : return 36;
			case "quiz review" : return 37;
			case "quiz view" : return 38;
			case "quiz view all" : return 39;
			case "quiz view summary" : return 40;
			case "resource view" : return 41;
			case "resource view all" : return 42;
			case "scorm pre-view" : return 43;
			case "scorm view" : return 44;
			case "scorm view all" : return 45;
			case "upload upload" : return 46;
			case "user update" : return 47;
			case "user view" : return 48;
			case "user view all" : return 49;
			default : return 0;
		}
	}
}
