//package com.soli.dev.board.service;
//
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.core.types.Predicate;
//import kr.or.semas24.cmmn.Events;
//import kr.or.semas24.cmmn.base.BaseCrudService;
//import kr.or.semas24.isbm.biz.arph.AplyRcptPrgrsMdleSttsCd;
//import kr.or.semas24.isbm.biz.arph.PrgrsDtlEvent;
//import kr.or.semas24.isbm.biz.arph.PrgrsEndEvent;
//import kr.or.semas24.isbm.biz.arph.PrgrsStartEvent;
//import kr.or.semas24.isbm.biz.mdle.aplyRcpt.dto.BmAplyBscDto;
//import kr.or.semas24.isbm.biz.mdle.aplyRcpt.service.BmAplyBscService;
//import kr.or.semas24.isbm.biz.mdle.bpc.dto.BmAplyRcptBizPropCnclDto;
//import kr.or.semas24.isbm.biz.mdle.bpc.dto.BmBizPropCnclCmpoNmprDto;
//import kr.or.semas24.isbm.biz.mdle.bpc.dto.BmBizPropCnclDto;
//import kr.or.semas24.isbm.biz.mdle.bpc.entity.BmBizPropCncl;
//import kr.or.semas24.isbm.biz.mdle.bpc.repository.BmBizPropCnclRepository;
//import kr.or.semas24.isbm.biz.mng.dto.BmSprtBizProcDto;
//import org.springframework.context.event.EventListener;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * 사업추진협의회 Service
// */
//@Service
//public class BoardService extends BaseCrudService<BmBizPropCnclDto, BmBizPropCncl, Long> {
//
//    /**
//     * 신청기본정보
//     */
//    private final BmAplyBscService bmAplyBscService;
//
//    /**
//     * 사업추진협의회구성인원
//     */
//    private final BmBizPropCnclCmpoNmprService bmBizPropCnclCmpoNmprService;
//
//    /**
//     * 사업추진협의회 Repository
//     */
//    private final BmBizPropCnclRepository bmBizPropCnclRepository;
//
//    /**
//     * 사업추진협의회 Service 생성자
//     */
//    public BoardService(BmAplyBscService bmAplyBscService, BmBizPropCnclCmpoNmprService bmBizPropCnclCmpoNmprService, BmBizPropCnclRepository bmBizPropCnclRepository) {
//        super(bmBizPropCnclRepository);
//        this.bmAplyBscService = bmAplyBscService;
//        this.bmBizPropCnclCmpoNmprService = bmBizPropCnclCmpoNmprService;
//        this.bmBizPropCnclRepository = bmBizPropCnclRepository;
//    }
//
//    /**
//     * 사업추진협의회 서술부
//     */
//    protected Predicate getPredicate(BmBizPropCnclDto dto) {
//        BooleanBuilder booleanBuilder = new BooleanBuilder();
//
//        return booleanBuilder;
//    }
//
//    /**
//     * 사업추진협의회 현황 목록 조회
//     * @param dto
//     * @param pageable
//     * @return
//     */
//    @Transactional(readOnly = true)
//    public Page<BmAplyRcptBizPropCnclDto> selectBizPropCncl(BmAplyRcptBizPropCnclDto dto, Pageable pageable) {
//        return bind(bmBizPropCnclRepository.selectBizPropCncl(dto, pageable), BmAplyRcptBizPropCnclDto.class);
//    }
//
//    /**
//     * 사업추진협의회 상세 조회
//     * @param dto
//     * @return
//     */
//    @Transactional(readOnly = true)
//    public BmBizPropCnclDto findBizPropCncl(BmBizPropCnclDto dto) {
//        BmBizPropCnclDto bizPropCncl = bind(bmBizPropCnclRepository.findBizPropCncl(dto), BmBizPropCnclDto.class);
//        return bizPropCncl;
//    }
//
//    /**
//     * 사업추진협의회 정보 저장
//     * @param dto
//     * @return
//     */
//    @Override
//    @Transactional
//    public BmBizPropCnclDto save(BmBizPropCnclDto dto) {
//        BmBizPropCnclDto bizPropCnclDtoSave = super.save(dto);
//
//        if (dto.getBizPropCnclCmpoNmprList().size() != 0) {
//
//            for (BmBizPropCnclCmpoNmprDto bizPropCnclCmpoNmpr : dto.getBizPropCnclCmpoNmprList()) {
//                bizPropCnclCmpoNmpr.setBizPropCnclSn(bizPropCnclDtoSave.getBizPropCnclSn());
//            }
//
//            bmBizPropCnclCmpoNmprService.saveAll(dto.getBizPropCnclCmpoNmprList());
//        }
//        return bizPropCnclDtoSave;
//    }
//
//    /**
//     * 민원진행상태 변경 Start, End
//     * @param event
//     */
//    @EventListener(classes = PrgrsStartEvent.class, condition = "#event.compnNm.equals('Bpc')")
//    public void handleProgrsChangeEvent (PrgrsStartEvent event) {
//        // 민원 진행상태 변경 수신
//        if (event.getSttsCd() == AplyRcptPrgrsMdleSttsCd.S) { // 최초 모듈 진입 민원들
//            // 민원들에 대한 모듈내 시작 상태 등 처리 필요
//            // 민원 진행된다는 문자 메시지 발송등
//            Events.publishAfterTransactionCommit(new PrgrsDtlEvent(event.getAplyRcptNoList(), event.getBmSprtBizProcDto().getProcSn()));
//
//            // 사업추진협의회 기본정보 저장
//            for (String aplyRcptNo : event.getAplyRcptNoList()) {
//                BmAplyBscDto aplyBscInfo = bmAplyBscService.find(aplyRcptNo);
//                BmSprtBizProcDto sprtBizProc = event.getBmSprtBizProcDto();
//                BmBizPropCnclDto bizPropCncl = new BmBizPropCnclDto();
//                bizPropCncl.setProcSn(sprtBizProc.getProcSn());
//                bizPropCncl.setAplyRcptNo(aplyRcptNo);
//                if (null != aplyBscInfo.getBzentyCd()) {
//                    bizPropCncl.setMrktCd(aplyBscInfo.getBzentyCd());
//                }
//                if (null != aplyBscInfo.getAplyBzentyNm()) {
//                    bizPropCncl.setMrktNm(aplyBscInfo.getAplyBzentyNm());
//                }
//                super.save(bizPropCncl);
//            }
//
//            //수시 등록을 해야하는 모듈 특성상 진입시점에 'E' 등록
//            Events.publishAfterTransactionCommit(new PrgrsEndEvent(event.getAplyRcptNoList(),event.getBmSprtBizProcDto().getProcSn()));
//        }
//    }
//}
