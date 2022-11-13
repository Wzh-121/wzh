#include<stdio.h> 
#include<stdlib.h>

//统计功能：计算战斗机的平均飞行高度，并输出大于平均飞行高度的战斗机型号。
void avg(char model[100][100], char height[100][100], int n) {
    float sum=0;
    int aaa=0;

    //统计战斗机平均飞行高度
    for(int i=0; i<n; i++) {
        aaa=atoi(height[i]);
        sum += aaa;
    }
    printf("\n");
    printf("平均飞行高度 = %.2f米\n",sum/n);
    printf("\n");
    printf("====================================================================================");
    printf("\n");

    //输出大于平均飞行高度的战斗机型号
    printf("\n");
    printf("大于平均飞行高度的战斗机型号有：\n");
    printf("\n");
    for(int i=0; i<n; i++) {
        aaa=atoi(height[i]);
        if(aaa > (sum/n)) {
            printf("%s, ",model[i]);
            printf("\t");
        }
    }
    printf("\n");
    printf("\n"); 
    printf("===================================================================================="); 
    printf("\n"); 
    printf("\n");
}

//排序功能：按照从大到小的顺序，依次地输出最大飞行高度值。
void sort(char height[100][100], int n) {
    int height1[100];
    int a, temp=0;

    //一维数组存储飞机飞行高度
    for(int i=0; i<n; i++) {
        a = atoi(height[i]);
        height1[i] = a;
    }

    //飞行高度从大到小排序
    //选择排序
    for(int i=0;i<n; i++) {
        for(int j=i+1;j<n; j++) {
            if(height1[i] < height1[j]) {
                temp=height1[i];
                height1[i]=height1[j];
                height1[j]=temp;
            }
        }
    }

    //依次输出最大飞行高度值
    printf("排序后输出：\n");
    printf("\n");
    for(int i=0; i<n; i++) {
        printf("%d米 \t",height1[i]);
    }
    printf("\n");
    printf("\n");
    printf("====================================================================================");
    printf("\n");
    
}

//主函数
//录入和浏览功能：将战斗机的型号和最大飞行高度分别录入到显示系统中，并给出输出
int main()
{
    int n;
    char model[100][100];
    char height[100][100]; 
    printf("请输入飞机个数:：\n");
    scanf("%d",&n);

    //录入飞机信息
    //二维数组存储飞机信息
    for(int i=0; i<n; i++) {
        printf("请输入飞机型号：");
        scanf("%s",model[i]);
        printf("请输入该型号飞机的飞行高度: ");
        scanf("%s",height[i]);
    }

     //输出飞机信息
    printf("\n");
    printf("====================================================================================");
    printf("\n");
    printf("\n");
    printf("输出飞机信息：\n");
    printf("\n");
    for(int i=0;i<n;i++) {
        printf("%s：",model[i]);
        printf("%s米  ",height[i]);
        printf("\t");
    }
    printf("\n");
    printf("\n");
    printf("====================================================================================");
    printf("\n");
    avg(model, height, n);
    sort(height, n);   

    return 0;
}