package com.tjoeun.onLinePoll;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PollReadEx {
	public static ArrayList<String> pollRead(String filepath)
	{
		// 텍스트 파일의 내용을 저장해서 리턴시킬 객체를 선언한다.
		ArrayList<String> poll = null;
		// 텍스트 파일의 내용을 읽어들이는 스캐너
		Scanner scanner = null;
		
		try {
			// 객체를 만든다. 파일의 내용을 읽어준다.
			scanner = new Scanner(new File(filepath));
			// 파일이 있어야 ArrayList 객체를 만든다.
			poll = new ArrayList<>();
			
			// 파일의 끝까지(더 이상 읽을 줄이 없을때 까지) 반복하며 텍스트 파일의 내용을 읽어온다.
			while(scanner.hasNextLine())
			{
				String str = scanner.nextLine().trim();
				// 읽어들인 줄이 빈 줄이 아니면 ArrayList에 저장한다.
				if (str != null) {
					poll.add(str);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 경로가 잘못되었거나 디스크에 파일이 존재하지 않습니다.");
		}
		return poll;
	}
}
