let employeeIndex = 0; // 전역 변수로 인덱스를 관리

function addEmployee(id, ename, name) {
    const container = document.getElementById('employeeInputsContainer');

    const inputGroup = document.createElement('div');
    inputGroup.classList.add('form-group');
    
    inputGroup.style.backgroundColor = '#f0f0f0';
    inputGroup.style.padding = '10px';
    inputGroup.style.marginBottom = '10px';
    inputGroup.style.borderRadius = '5px';
    
    inputGroup.innerHTML = `
        <div>
            사번: ${ename}
            <label>이름: ${name}</label>
            <input type="hidden" name="enterEmpList[${employeeIndex}].eid" value="${id}">
            직무: <input type="text" class="form-control" name="enterEmpList[${employeeIndex}].role">
            투입일: <input type="date" class="form-control" name="enterEmpList[${employeeIndex}].enterDate">
            <button type="button" class="btn btn-danger remove-btn">삭제</button>
        </div>
    `;

    // 삭제 버튼에 클릭 이벤트 리스너 추가
    inputGroup.querySelector('.remove-btn').addEventListener('click', function() {
        container.removeChild(inputGroup);
    });

    container.appendChild(inputGroup);
    console.log(inputGroup.innerHTML);

    employeeIndex++; // 인덱스 증가
}