/*
 * Copyright 2011 MOPAS(Ministry of Public Administration and Security).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.rte.tex.dlv.service.impl;

import java.util.List;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.tex.dlv.service.EgovDeliveryService;
import egovframework.rte.tex.pcs.service.PurchaseVO;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 입찰내역 및 납품상태에 관한 비지니스 클래스를 정의한다.
 *
 * @author 실행환경 개발팀 이영진
 * @since 2011.06.07
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.06.07  이영진          최초 생성
 *
 * </pre>
 */
@Service("egovDeliveryService")
public class EgovDeliveryServiceImpl extends EgovAbstractServiceImpl implements EgovDeliveryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovDeliveryServiceImpl.class);

	/** DeliveryDAO */
	@Resource(name = "deliveryDAO")
	DeliveryDAO deliveryDAO;

	/**
	 * 사용자의 입찰내역 조회한다.
	 * @param purchaseVO 입찰내역 정보
	 * @return List<PurchaseVO> 입찰내역 리스트
	 * @throws Exception
	 */
	@Override
	public List<PurchaseVO> selectPurchaseList(PurchaseVO purchaseVO) throws Exception {
		return deliveryDAO.selectPurchaseList(purchaseVO);
	}

	/**
	 * 전체 입찰내역 조회한다.(관리자용)
	 * @param purchaseVO 입찰내역 정보
	 * @return List<PurchaseVO> 입찰내역 리스트
	 * @throws Exception
	 */
	@Override
	public List<PurchaseVO> selectAllPurchaseList(PurchaseVO purchaseVO) throws Exception {
		return deliveryDAO.selectAllPurchaseList(purchaseVO);
	}

	/**
	 * 전체 입찰내역을 조회한다.(xml, Excel용)
	 * @return List<PurchaseVO> 입찰내역 리스트
	 * @throws Exception
	 */
	@Override
	public List<PurchaseVO> selectAllPurchaseXml() throws Exception {
		return deliveryDAO.selectAllPurchaseXml();
	}

	/**
	 * 납품상태 정보를 조회한다.
	 *
	 * @return List 납품상태 정보 리스트
	 * @throws Exception
	 */
	@Override
	public List<?> selectDeliveryInfoList() throws Exception {
		return deliveryDAO.selectDeliveryInfoList();
	}

	/**
	 * 납품상태를 변경한다.
	 *
	 * @param purchaseVO 입찰내역 정보
	 */
	@Override
	public void updateDeliveryStatus(PurchaseVO purchaseVO) throws Exception {
		LOGGER.debug(purchaseVO.toString());
		deliveryDAO.updateDeliveryStatus(purchaseVO);
	}

	/**
	 * 사용자의 입찰목록의 건수를 조회한다.
	 * @param purchaseVO 입찰내역정보
	 * @return int 입찰 건수
	 * @throws Exception
	 */
	@Override
	public int selectPurchaseListTotCnt(PurchaseVO purchaseVO) throws Exception {
		return deliveryDAO.selectGoodsListTotCnt(purchaseVO);
	}

	/**
	 * 전체 입찰목록의 건수를 조회한다.(관리자용)
	 * @param purchaseVO 입찰내역 정보
	 * @return int 입찰건수
	 * @throws Exception
	 */
	@Override
	public int selectAllPurchaseListTotCnt(PurchaseVO purchaseVO) throws Exception {
		return deliveryDAO.selectAllGoodsListTotCnt(purchaseVO);
	}

}
