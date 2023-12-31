package com.tjoeun.onLinePoll;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PollWriteEx {

// 텍스트 파일에 저장한 데이터가 저장된 ArrayList를 넘겨받아 텍스트 파일로 저장하는 메소드
	public static void pollwrite(String filepath, ArrayList<String> poll)
	{
		// ArrayList에 저장된 데이터를 텍스트 파일로 출력하기 위해 PrintWriter 클래스 객체를 '선언'한다.
		PrintWriter printWriter = null;
		
		try {
			// ArrayList에 저장할 데이터를 텍스트 파일로 출력할 PrintWriter 클래스 객체를 '생성'한다.
			printWriter = new PrintWriter(filepath);
			
			// ArrayList에 저장된 데이터의 개수만큼 반복하며 텍스트 파일로 출력한다.
			for(String str : poll)
			{
				printWriter.write(str+"\r\n");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("디스크에 파일이 존재하지 않습니다.");
		} finally 
		{
			// 출력 객체를 닫지 않으면 파일로 출력하는 데이터가 저장되지 않기 때문에 
			// 텍스트 파일 출력에 사용한 객체를 반드시 닫아야 한다.
			if (printWriter != null)printWriter.close();
		}
		
		
	}
	
}
