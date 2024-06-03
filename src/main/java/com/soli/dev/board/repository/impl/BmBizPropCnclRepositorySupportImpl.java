//package com.soli.dev.board.repository.impl;
//
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.core.types.Projections;
//import com.querydsl.core.types.dsl.Expressions;
//import com.querydsl.jpa.JPAExpressions;
//import com.querydsl.jpa.JPQLQuery;
//import com.querydsl.jpa.impl.JPAQuery;
//import kr.or.semas24.cmmn.base.BaseRepositorySupport;
//import kr.or.semas24.cmmn.base.support.DateTimeRangePredicate;
//import kr.or.semas24.cmmn.base.support.PageQueryHelper;
//import kr.or.semas24.isbm.biz.arph.entity.QVAplyRcptPrgrsHstry;
//import kr.or.semas24.isbm.biz.mdle.aplyRcpt.entity.QBmAplyBsc;
//import kr.or.semas24.isbm.biz.mdle.aplyRcpt.entity.QBmAplyRcpt;
//import kr.or.semas24.isbm.biz.mdle.bpc.dto.BmAplyRcptBizPropCnclDto;
//import kr.or.semas24.isbm.biz.mdle.bpc.dto.BmBizPropCnclDto;
//import kr.or.semas24.isbm.biz.mdle.bpc.entity.QBmBizPropCncl;
//import kr.or.semas24.isbm.biz.mdle.bpc.entity.QBmBizPropCnclCmpoNmpr;
//import kr.or.semas24.isbm.biz.mdle.bpc.repository.BmBizPropCnclRepositorySupport;
//import kr.or.semas24.isbm.sys.eum.entity.QMdExtrlUserManage;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//
///**
// * 사업추진협의회 RepositorySupport 구현체
// */
//public class BmBizPropCnclRepositorySupportImpl extends BaseRepositorySupport implements BmBizPropCnclRepositorySupport {
//
//    // 사업추진협의회
//    QBmBizPropCncl bizPropCnclJap = QBmBizPropCncl.bmBizPropCncl;
//    // 사업추진협의회구성인원
//    QBmBizPropCnclCmpoNmpr bizPropCnclCmpoNmprJpa = QBmBizPropCnclCmpoNmpr.bmBizPropCnclCmpoNmpr;
//
//    /**
//     * 사업추진협의회 현황 목록 조회
//     * @param dto
//     * @param pageable
//     * @return
//     */
//    @Override
//    public Page<BmAplyRcptBizPropCnclDto> selectBizPropCncl(BmAplyRcptBizPropCnclDto dto, Pageable pageable) {
//
//        if (null == dto) {
//            return Page.empty();
//        }
//
//        // 신청접수진행이력 뷰
//        QVAplyRcptPrgrsHstry vHstryJap = QVAplyRcptPrgrsHstry.vAplyRcptPrgrsHstry;
//        // 신청접수정보
//        QBmAplyRcpt aplyRcptJap = QBmAplyRcpt.bmAplyRcpt;
//        // 신청기본정보
//        QBmAplyBsc aplyBscJap = QBmAplyBsc.bmAplyBsc;
//        // 외부사용자
//        QMdExtrlUserManage extrUserJpa = QMdExtrlUserManage.mdExtrlUserManage;
//
//        BooleanBuilder booleanBuilder = new BooleanBuilder();
//
//        // 공고일련번호
//        if (null != dto.getPbancSn()) {
//            booleanBuilder.and(aplyRcptJap.pbancSn.eq(dto.getPbancSn()));
//        }
//
//        // 신청접수번호
//        if (null != dto.getAplyRcptNo()) {
//            booleanBuilder.and(aplyRcptJap.aplyRcptNo.eq(dto.getAplyRcptNo()));
//        }
//
//        // 업체명 ( 시장명, 기관명, 지원시장명 )
//        if (null != dto.getAplyBzentyNm()) {
//            booleanBuilder.and(aplyBscJap.aplyBzentyNm.contains(dto.getAplyBzentyNm()));
//        }
//
//        // 상인회명
//        if (null != dto.getMrcaNm()) {
//            booleanBuilder.and(aplyBscJap.mrcaNm.contains(dto.getMrcaNm()));
//        }
//
//        // 신청자명
//        if (null != dto.getAplcntNm()) {
//            // 암호화된 외부사용자명 복호화
//            booleanBuilder.and(Expressions.booleanTemplate("XX1.ENC_INDEX_VARCHAR(USER_FLNM, 'ARIA256') like '%' || XX1.ENC_INDEX_VARCHAR_SEL({0}, 'ARIA256')||'%'", dto.getAplcntNm()));
//        }
//
//        // 사업자등록번호 ( 상인회사업자번호 )
//        if (null != dto.getBrno()) {
//            booleanBuilder.and(aplyBscJap.brno.eq(dto.getBrno()));
//        }
//
//        // 시/도
//        if (null != dto.getCtpvCd()) {
//            booleanBuilder.and(aplyBscJap.ctpvCd.eq(dto.getCtpvCd()));
//        }
//
//        // 시/군/구
//        if (null != dto.getSggCd()) {
//            booleanBuilder.and(aplyBscJap.sggCd.eq(dto.getSggCd()));
//        }
//
//        // 신청일자
//        if (null != dto.getAplyPd()) {
//            booleanBuilder.and(new DateTimeRangePredicate(aplyRcptJap.aplyDt, dto.getAplyPd()));
//        }
//
//        // 접수일자
//        if (null != dto.getRcptPd()) {
//            booleanBuilder.and(new DateTimeRangePredicate(aplyRcptJap.rcptDt, dto.getRcptPd()));
//        }
//
//        // 위원장명
//        if (null != dto.getBizPropCnclMfcmmFlnm()) {
//            booleanBuilder.and(bizPropCnclJap.bizPropCnclSn.in(
//                    new JPQLQuery[]{JPAExpressions
//                            .select(bizPropCnclCmpoNmprJpa.bizPropCnclSn)
//                            .from(bizPropCnclCmpoNmprJpa)
//                            .where(bizPropCnclCmpoNmprJpa.bizPropCnclMfcmmFlnm.contains(dto.getBizPropCnclMfcmmFlnm()))
//                    }
//            ));
//        }
//
//        // 사업추진협의회 진행상태에 도달한 접수번호만 조회
//        booleanBuilder.and(aplyRcptJap.aplyRcptNo.in(
//                new JPQLQuery[]{JPAExpressions
//                        .select(vHstryJap.aplyRcptNo)
//                        .from(vHstryJap)
//                        .where(vHstryJap.procSn.eq(dto.getProcSn()))
//                }
//        ));
//
//        JPAQuery<BmAplyRcptBizPropCnclDto> query = getQueryFactory()
//                .select(Projections.fields(BmAplyRcptBizPropCnclDto.class,
//                        aplyRcptJap.aplyRcptNo,
//                        aplyRcptJap.pbancSn,
//                        aplyRcptJap.procSn,
//                        aplyRcptJap.aplyDt,
//                        aplyRcptJap.rcptDt,
//                        aplyRcptJap.picId,
//                        Expressions.as(extrUserJpa.userFlnm, "aplcntNm"),
//                        bizPropCnclJap.bizPropCnclSn))
//                .from(aplyRcptJap) // 신청접수
//                .innerJoin(aplyBscJap).on(aplyRcptJap.aplyRcptNo.eq(aplyBscJap.aplyRcptNo)) // 신청기본정보
//                .leftJoin(extrUserJpa).on(aplyRcptJap.aplcntId.eq(extrUserJpa.userId)) // 외부사용자
//                .leftJoin(bizPropCnclJap).on(aplyRcptJap.aplyRcptNo.eq(bizPropCnclJap.aplyRcptNo)) // 사업추진협의회
//                .where(booleanBuilder)
//                .orderBy(aplyRcptJap.aplyRcptNo.desc());
//
//        Page<BmAplyRcptBizPropCnclDto> list = PageQueryHelper.fetchPaged(pageable, query, aplyRcptJap.aplyRcptNo);
//
//        return list;
//    }
//
//    /**
//     * 사업추진협의회 상세 조회
//     * @param dto
//     * @return
//     */
//    @Override
//    public BmBizPropCnclDto findBizPropCncl(BmBizPropCnclDto dto) {
//        List<BmBizPropCnclDto> bizPropCncl = getQueryFactory()
//                .selectFrom(bizPropCnclJap)
//                .where(bizPropCnclJap.procSn.eq(dto.getProcSn()).and(bizPropCnclJap.aplyRcptNo.eq(dto.getAplyRcptNo())))
//                .fetch().stream().map(entity -> entity.of(BmBizPropCnclDto.class))
//                .toList();
//
//        if (bizPropCncl.size() > 0) {
//            return bizPropCncl.get(0);
//        }
//
//        BmBizPropCnclDto bizPropCnclDto = new BmBizPropCnclDto();
//        return bizPropCnclDto;
//    }
//}
