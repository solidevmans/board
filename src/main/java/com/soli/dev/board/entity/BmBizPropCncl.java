//package com.soli.dev.board.entity;
//
//import kr.or.semas24.cmmn.Globals;
//import kr.or.semas24.cmmn.base.BaseAuditedEntity;
//import lombok.Getter;
//import org.hibernate.annotations.DynamicUpdate;
//
//import javax.persistence.*;
//
///**
// * 사업추진협의회 엔티티
// */
//@Entity
//@Getter
//@Table(name = "TB_BM_BIZ_PROP_CNCL")
//@TableGenerator(
//        name = "TB_BM_BIZ_PROP_CNCL_SEQ_GENERATOR",
//        table = Globals.SEQUENCE_TABLE,
//        pkColumnName = Globals.SEQUENCE_PK_COLUMN_NAME,
//        pkColumnValue = "TB_BM_BIZ_PROP_CNCL.BIZ_PROP_CNCL_SN",
//        valueColumnName = Globals.SEQUENCE_VALUE_COLUMN_NAME,
//        allocationSize = 1
//)
//@DynamicUpdate
//public class BmBizPropCncl extends BaseAuditedEntity {
//
//    /**
//     * 사업추진협의회일련번호
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TB_BM_BIZ_PROP_CNCL_SEQ_GENERATOR")
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
//    private String aplyRcptNo;
//
//    /**
//     * 시장코드
//     */
//    private String mrktCd;
//
//    /**
//     * 시장명
//     */
//    private String mrktNm;
//
//    /**
//     * 키 조회
//     */
//    public Object getKey() { return this.bizPropCnclSn; }
//
//}
