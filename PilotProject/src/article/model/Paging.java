package article.model;

public class Paging {
	private int page = 1; // ���� ������
	private int totalCount; // ��ü �Խñۼ�
	private int beginPage; // ��� ����
	private int endPage; // ��� ��
	private int displayRow = 10; // �� �������� �� �� row
	private int displayPage = 10; // �� �������� �� �� ������
	boolean prev; // prev ��ư�� ������/�� ������
	boolean next; // �� ������ ���� 10�� �Ѵ� ��츸 true

	public void setTotalCount(int totalCount) {
		// �̰� �� ȣ���ؾ� paging�� �����ϱ� ������
		// �̰� ȣ���ϸ� �ڵ����� paging() �Լ� ȣ���ϵ��� ����
		this.totalCount = totalCount;
		paging();
	}

	private void paging(){
        //displayPage = 10(������)
        //prev,next,beginPage,endPage �� ����ؼ� �����.
        endPage = ((page+(displayPage-1))/displayPage)*displayPage;
        beginPage = endPage - (displayPage-1);
        
        //���� 32����� �ʿ��� �������� 4��
        //32/10 = 3.2 �ø��ؼ� 4
        int totalPage = (int)Math.ceil(totalCount/(double)displayRow);
        if(totalPage<endPage){
            endPage = totalPage;
            next=false;
        }else{
            next=true;
        }
        prev=(beginPage == 1)?false:true;
    }

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getDisplayRow() {
		return displayRow;
	}

	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}

	public int getDisplayPage() {
		return displayPage;
	}

	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotalCount() {
		return totalCount;
	}
	
	

}