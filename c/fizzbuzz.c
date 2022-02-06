#include <stdbool.h>
#include <stdio.h>

#define FIZZ "Fizz"
#define BUZZ "Buzz"

static bool fizz(int n) { 
    return n % 3 == 0;
}

static bool buzz(int n) {
    return n % 5 == 0;
}

int main(void) {
    for(int i = 1; i <= 100; ++i) {
        if(fizz(i) && buzz(i)) {
            printf(FIZZ BUZZ "\n");
        } else if(fizz(i)) {
            printf(FIZZ "\n");
        } else if(buzz(i)) {
            printf(BUZZ "\n");
        } else {
            printf("%d\n", i);
        }
    }
}
