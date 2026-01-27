package com.example.boardv1.board;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

// Service는 Repository에 의존
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> 게시글목록() {
        return boardRepository.findAll();
    }

    public Board 상세보기(int id) {
        return boardRepository.findById(id);
    }

    @Transactional // update, delete, insert할 때 붙이기
    public void 게시글수정(int id, String title, String content) {
        Board board = boardRepository.findById(id);
        board.setTitle(title);
        board.setContent(content);
    }

}
