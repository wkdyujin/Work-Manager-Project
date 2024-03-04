function addEmployee(pid, eid, ename, name) {
    // 평가 div 보이게 하기
    const evaluationDiv = document.querySelector('.evaluation');
    evaluationDiv.style.display = 'block';

    // 평가 form action URL 업데이트
    const form = document.querySelector('.evaluation form');
    form.action = `/evaluation/internal/${pid}/${eid}`; // projectId는 현재 페이지의 프로젝트 ID

    // 숨김 필드에 선택된 사원의 ID와 이름을 설정
    document.getElementById('selectedEmployeeId').value = eid;
    document.getElementById('selectedEmployeeName').value = name;

    // 선택된 사원의 ID와 이름을 사용자가 볼 수 있도록 폼 내에 표시
    const employeeInfoDisplay = document.querySelector('.evaluation .employee-info');
    employeeInfoDisplay.innerHTML = `사번: ${ename}<br>사원명: ${name}<br>`;
    
    // 폼 내용 초기화
    form.reset();
}
