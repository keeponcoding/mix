package com.cll.mix.algorithm;

/**
 * @ClassName SortApp
 * @Description 排序算法
 *
 * 参考：https://www.cnblogs.com/onepixel/articles/7674659.html
 *
 * @Author cll
 * @Date 2020/2/18 11:35 上午
 * @Version 1.0
 **/
public class SortApp {

    public static void main(String[] args) {
        int nums[] = {3,1,57,22,7,34,14};

        /*
         * 最基本的三种排序算法
         */
        // 冒泡排序
        // bubbleSort(nums);

        // 选择排序
        // selectSort(nums);

        // 插入排序
        // insertSort(nums);

        /*
         * 高阶排序算法
         */
        // 希尔排序
        // shellSort(nums);

        // 归并排序
        mergeSort(nums);
    }



    /**
     * 冒泡排序 (Bubble Sort)
     * 时间复杂度 O(n^2)
     * 它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端
     * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 3.针对所有的元素重复以上的步骤，除了最后一个；
     * 4.重复步骤1~3，直到排序完成。
     */
    public static void bubbleSort(int nums[]) {
        int temp = 0;
        // 定义一个标签 true 表示做了交换  false 表示没有做交换
        // 如果一轮内层循环下来 没有做任何交换 说明数组已经是有序的状态  那么就无需在往下遍历
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            // 每次循环都会把最大的值 移动到最后的位置   那么下次就不需要考虑最后的位置  因为已经是最大值了
            // 所以 j < nums.length - 1 - i
            // - i 就是仅考虑次最大的位置   每次都会少考虑 - i 个元素
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j+1]){ // 比较相邻元素
                    // 交换
                    temp = nums[j]; // 大值
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true; // 做了交换 flag 置为true
                }
            }

            // 判断falg
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 选择排序 (Selection-sort)
     * 时间复杂度 O(n^2)
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     */
    public static void selectSort(int[] nums) {
        int temp = 0;
        int minIdx = 0;
        for (int i = 0; i < nums.length-1; i++) {
            minIdx = i;
            // 循环遍历  找出小于 角标为minIdx 的元素角标  并赋值给minIdx
            // 每次都需要找到 最后一个元素为止
            for (int j = i+1; j < nums.length; j++) {
                if (nums[minIdx] > nums[j]) { //
                    minIdx = j;
                }
            }

            // 由前一步循环找出最小元素角标  并将元素交换位置
            temp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = temp;
        }
    }

    /**
     * 插入排序 (Insertion-Sort)
     * 时间复杂度 O(n)～O(n^2)
     * 每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
     * 1.从第一个元素开始，该元素可以认为已经被排序；
     * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5.将新元素插入到该位置后；
     * 6.重复步骤2~5。
     */
    public static void insertSort(int[] nums) {

        int temp = 0;
        // 外层循环 遍历待比较的单个数据
        for (int i = 1; i < nums.length; i++) {
            // 内层循环 遍历已经排好序的子集
            // nums[j-1] 之前的数据
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j-1]) { // 比较大小
                    // 交换 将小数排前面
                    temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                } else {
                    /*
                     * 当 nums[j] >= nums[j-1] 时 跳出循环
                     * 因为 nums[j-1] 之前的数据是已经排好序的  都已经比最大的还大   就没必要继续往前比较下去
                     * 直接跳出循环
                     */
                    break;
                }

                /*if (nums[j] >= nums[j-1]) {
                    break;
                }
                // 交换 将小数排前面
                temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;*/
            }
        }
    }

    /**
     * 希尔排序 (Shell Sort)
     *
     * 参考：https://www.cnblogs.com/chengxiao/p/6104371.html
     *
     * 简单插入排序的改进版，它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
     * 1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 2.按增量序列个数k，对序列进行k 趟排序；
     * 3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     */
    public static void shellSort(int[] nums) {

    }

    /**
     * 归并排序 (Merge Sort)   代码未理解
     *
     * 参考：https://www.cnblogs.com/chengxiao/p/6194356.html
     *
     * 该算法是采用分治法（Divide and Conquer）
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并
     * 1.把长度为n的输入序列分成两个长度为n/2的子序列；
     * 2.对这两个子序列分别采用归并排序；
     * 3.将两个排序好的子序列合并成一个最终的排序序列。
     */
    public static void mergeSort(int[] nums) {
        int []temp = new int[nums.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(nums,0,nums.length-1,temp);
    }

    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }

    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

    /**
     * 快速排序 (Quick Sort)
     * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序
     * 1.从数列中挑出一个元素，称为 “基准”（pivot）；
     * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     */

    /**
     * 堆排序 (Heap Sort)
     * 利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
     * 1.将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
     * 2.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
     * 3.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
     */

    /**
     * 计数排序 (Counting Sort)
     * 将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
     * 1.找出待排序的数组中最大和最小的元素；
     * 2.统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
     * 3.对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
     * 4.反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
     */

    /**
     * 桶排序 (Bucket Sort)
     * 是计数排序的升级版，它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
     * 桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）
     * 1.设置一个定量的数组当作空桶；
     * 2.遍历输入数据，并且把数据一个一个放到对应的桶里去；
     * 3.对每个不是空的桶进行排序；
     * 4.从不是空的桶里把排好序的数据拼接起来。
     */

    /**
     * 基数排序 (Radix Sort)
     * 按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
     * 有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。
     * 最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
     *
     * 1.取得数组中的最大数，并取得位数；
     * 2.arr为原始数组，从最低位开始取每个位组成radix数组；
     * 3.对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     */

    /**
     * 交换数组元素
     * @param arr 待排序数组
     * @param a   待交换index
     * @param b   待交换index
     * 该函数可以有效避免定义第三个变量 仅适用于int[]
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}
