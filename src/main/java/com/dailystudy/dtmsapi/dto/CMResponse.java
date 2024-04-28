package com.dailystudy.dtmsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//public class CMResponse { //커스텀 메시지 응답
//    private String message;
//    private Map<String, String> errorMap;
//}
//위 코드를 공통 적용하려면 데이터 형식 안맞으면 못쓰기 때문에 아래처럼 수정
public class CMResponse<T> { //제네릭을 사용해서 CMResponse 클래스를 사용하는곳에서 데이터타입을 정해준다
    private int code; //1(성공),-1(실패)
    private String message;
    private T data;
}
