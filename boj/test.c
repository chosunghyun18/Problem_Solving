#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int add(int a, int b)
{
    int result;
    result = a + b;
    return result;
}
int sum(int a, int b)
{
    int result;
    result = a - b;
    return result;
}
int mul(int a, int b)
{
    int result;
    result = a * b;
    return result;
}
int div(int a, int b)
{
    int result;
    result = a / b;
    return result;
}

int main()
{
    int k, n;
    int x;
    int i =0;
    while(i !=0 )
    {
        printf("첫번째 정수를 입력하시오: ");
        scanf("%d", &k);
        printf("두번째 정수를 입력하시오: ");
        scanf("%d", &n);
        printf("+: 1, -: 2, *: 3, /: 4, Reset: 5, End: 0 \n");
        printf("연산할 부호를 고르시오: ");
        scanf("%d", &x);

        if (x == 1)
        {
            printf("%d", add(k, n));     
        }
        else if (x == 2)
        {
            printf("%d", sum(k, n));
        }
        else if (x == 3)
        {
            printf("%d", mul(k, n));
        }
        else if (x == 4)
            printf("%d", div(k, n));
        else if (x == 5)
            printf("Reset");
        else if (x == 0)
            printf("End");
            i = 1;
    }
    printf("thisis end");
    return 0;
}
