// 이미지 첨부 조건 검사
const checkAttaches = () => {
    let checkOk = true;
    const attaches = document.querySelector('#attachs')
    // 이미지 첨부파일이 하나 이상이라면
    if('files' in attaches && attaches.files.length > 0) {
        // input태그 이름 . files 형태
        // url에 접근하려면 .value로 못 가져옴.
        for (attache of attaches.files) {
        //console.log(attache.name + ',' + attache.type + ',' + attache.size);
            // 이미지 파일의 MIME 형식
            // image/jpg,image/jpeg,image/png,image/gif
            if(!attache.type.startsWith('image')){
                alert('첨부하려는 파일은 반드시 이미지여야 합니다!');
                checkOk = false;
            }
        }
    } else{
        alert('하나 이상의 이미지를 선택하세요!!');
        checkOk = false;
    }
    return checkOk;
}
// 새글쓰기
const writebtn = document.querySelector("#writebtn");
writebtn?.addEventListener('click', () => {
    const galfrm = document.forms.galfrm;
    if(galfrm.title.value === '') alert('제목을 작성하세요!');
    else if(galfrm.content.value === '') alert('본문을 작성하세요!');
    else if(!checkAttaches()) alert('이미지 첨부 조건 불일치!');
    else if(grecaptcha.getResponse() === '') alert('자동가입방지를 확인하세요!');
    else {
        galfrm.method = 'post';
        galfrm.enctype = 'multipart/form-data';
        galfrm.submit();
    }

});

// 목록보기
const newbtn = document.querySelector("#newbtn");
newbtn?.addEventListener('click', () => {
    location.href = '/gallery/write';
})