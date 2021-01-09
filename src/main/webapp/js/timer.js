let timer = document.querySelector("#timer");

let result = document.querySelector("#result");

let timerFunction = () => {
    return new Promise((resolve,reject) => {
        let count;

        let interval = setInterval(() => {
            count = parseInt(timer.innerHTML) - 1;
            timer.innerHTML = count;
                    if(count === 0){
                        resolve("OK");
                        clearInterval(interval);
                    }
            count--;
        },1000);
    });
}

let form = '<form action="" method="POST" class="form-inline my-2 my-lg-0"><button class="btn btn-success btn-sm" type="submit">Claim points</button></form>';

timerFunction().then(() => {
    result.innerHTML = form;
});

console.log("connected");