package com.soli.dev.board.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 게시판 Controller
 */
@RestController
@RequiredArgsConstructor
public class BoardController {

    /**
     * 게시판 Service
     */
//    private final BoardService boardService;


    /**
     * 게시판 현황 목록 조회
     * @return
     */
    @GetMapping(name = "사업추진협의회 현황 목록 조회", path = "list")
    public String list() {
        return "테스트";
    }

}
