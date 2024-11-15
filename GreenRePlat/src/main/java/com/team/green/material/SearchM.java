package com.team.green.material;

public class SearchM {

	// �˻����
	private String searchWord; /* �˻��� */
	private String searchOption; /* �˻� �ɼ� */

	// ����¡
	// �Է¹��� ������
	private int pageNo = 1; /* ���� ������ ��ȣ */
	private int rowSizePerPage = 12; /* �� �������� ������ �Խñ� �� */

	private int materialCount; /* ��ü �Խñ� �� */

	// WHERE rnum BETWEEN start AND end
	private int start; /* ���� �� ��ȣ */
	private int end; /* �� �� ��ȣ */

	// ȭ�鿡 �׷����� ������ ��ȣ�� ù��°�� �������� ����
	private int firstPage;
	private int lastPage;

	// ������ �������� ��ȣ
	private int finalPage;

	public SearchM() {
	}

	@Override
	public String toString() {
		return "SearchM [seachWord=" + searchWord + ", seachOption=" + searchOption + ", pageNo=" + pageNo
				+ ", rowSizePerPage=" + rowSizePerPage + ", materialCount=" + materialCount + ", start=" + start
				+ ", end=" + end + ", firstPage=" + firstPage + ", lastPage=" + lastPage + ", finalPage=" + finalPage
				+ "]";
	}

	public SearchM(String seachWord, String seachOption, int pageNo, int rowSizePerPage, int materialCount, int start,
			int end, int firstPage, int lastPage, int finalPage) {
		super();
		this.searchWord = seachWord;
		this.searchOption = seachOption;
		this.pageNo = pageNo;
		this.rowSizePerPage = rowSizePerPage;
		this.materialCount = materialCount;
		this.start = start;
		this.end = end;
		this.firstPage = firstPage;
		this.lastPage = lastPage;
		this.finalPage = finalPage;
	}

	public void setting() {
		start = rowSizePerPage * (pageNo - 1) + 1;
		end = rowSizePerPage * pageNo;

		// ȭ�鿡 �׷��� �������ѹ��� ������ 10���� ���
		// pageNo�� 1~10 �� 1~10 ������ ��� firstPage = 1 | lastPage = 10
		// pageNo�� 11~20 �� 11~20 ������ ��� firstPage = 11 | lastPage = 20
		// pageNo�� 21~30 �� 21~30 ������ ��� firstPage = 21 | lastPage = 30
		firstPage = ((pageNo - 1) / 10) * 10 + 1;
		lastPage = firstPage + 9;

		// ��ü �Խñ� ���� 409���� �ִ�
		// ��ü �������� ����? 41�� (=������ ������ ��ȣ)
		// ��ü �Խñۼ��� 324���� �ִ�.
		// ��ü �������� ���� 33��
		// 324 / rowSizePerPage -> 32.4 -> 33
		finalPage = (int) Math.ceil((double) materialCount / rowSizePerPage);

		// ���� lastPage�� finalPage���� ũ�ٸ� �����ϰ� ����
		if (lastPage > finalPage) {
			lastPage = finalPage;
		}
		
	}

	public String getSeachWord() {
		return searchWord;
	}

	public void setSeachWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getSeachOption() {
		return searchOption;
	}

	public void setSeachOption(String seachOption) {
		this.searchOption = seachOption;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getRowSizePerPage() {
		return rowSizePerPage;
	}

	public void setRowSizePerPage(int rowSizePerPage) {
		this.rowSizePerPage = rowSizePerPage;
	}

	public int getMaterialCount() {
		return materialCount;
	}

	public void setMaterialCount(int materialCount) {
		this.materialCount = materialCount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getFinalPage() {
		return finalPage;
	}

	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}

}