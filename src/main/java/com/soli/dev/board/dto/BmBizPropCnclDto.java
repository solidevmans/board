//package com.soli.dev.board.dto;
//
//import kr.or.semas24.cmmn.base.BaseAuditedDto;
//import kr.or.semas24.cmmn.base.Bind;
//import kr.or.semas24.cmmn.validator.IsString;
//import kr.or.semas24.isbm.biz.mdle.bpc.entity.BmBizPropCncl;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//
///**
// * 사업추진협의회 DTO
// */
//@Getter
//@Setter
//public class BmBizPropCnclDto extends BaseAuditedDto<BmBizPropCncl> {
//
//    /**
//     * 사업추진협의회일련번호
//     */
//    private Long bizPropCnclSn;
//
//    /**
//     * 절차일련번호
//     */
//    private Long procSn;
//
//    /**
//     * 공고일련번호
//     */
//    private Long pbancSn;
//
//    /**
//     * 신청접수번호
//     */
//    @IsString(value = "신청접수번호", maxByte = 50)
//    private String aplyRcptNo;
//
//    /**
//     * 시장코드
//     */
//    @IsString(value = "시장코드", maxByte = 12, notBlank = true)
//    private String mrktCd;
//
//    /**
//     * 시장명
//     */
//    @IsString(value = "시장명", maxByte = 200)
//    private String mrktNm;
//
//    /**
//     * 사업추진협의회구성원
//     */
//    @Bind(idProperty = "bizPropCnclSn", joinProperty = "bizPropCnclSn")
//    private List<BmBizPropCnclCmpoNmprDto> bizPropCnclCmpoNmprList;
//
//}
