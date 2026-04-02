let index=1;
function changeSlide(n){
    showSlide(index+=n)

}
function showSlide(n){
    let slide=document.getElementsByClassName('slide');
    if(n>slide.length){
        index=1;
    }
    if (n<1){
        index=slide.length;
    }
    for (let i=0;i<slide.length;i++){
        slide[i].style.display='none';
    }
    slide[index-1].style.display='block';

}
document.addEventListener("DOMContentLoaded", function() {
    showSlide(index);
});