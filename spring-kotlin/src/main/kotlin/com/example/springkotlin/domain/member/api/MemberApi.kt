package com.example.springkotlin.domain.member.api

import com.example.springkotlin.domain.member.dao.MemberRepository
import com.example.springkotlin.domain.member.domain.Member
import com.example.springkotlin.domain.member.dto.MemberSignUpRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/members")
class MemberApi constructor(
        private var memberRepository: MemberRepository) {

    @PostMapping
    fun createMember(@RequestBody dto: MemberSignUpRequest): Member {
        return memberRepository.save(dto.toEntity())
    }

    @GetMapping
    fun getMembers(page: Pageable): Page<Member> {
        return memberRepository.findAll(page)
    }

}