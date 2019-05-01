acc_data1/acc_data2均为直行60步（步长0.6m）的数据

acc_data3/acc_data4均为直行60m（步长不一、步频不一）的数据

acc_data5均为直行60m（步长0.6m）的数据
三个值对应：
acc_max-acc_min   acc_average    time

得到的结果：用acc_data1训练
Weiberg模型：
C = 0.4293  ψ=+0.0435
Kim模型：
C =0.1665    ψ=+0.0024
Scarlet模型：
C =0.2636   ψ=+0.0370

误差                    acc_data2测试       acc_data3测试    acc_data4测试     acc_data5测试
Weiberg模型：    -0.1412                     9.7601                11.8880              -0.6659
Kim模型：           -0.00172                   27.7233               23.2474              -12.3729
Scarlet模型：       0.0172                     14.2590               16.5870              -0.5792
线性模型：           -0.0247                     4.6687                 5.3017                0.1227