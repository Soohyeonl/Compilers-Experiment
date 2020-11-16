##include <stdio.h>

int main() {
    char str[200] = {0};
    while (scanf("%s", str) != EOF) {
        printf("%s", str);
    }
}