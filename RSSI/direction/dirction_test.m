dir_name = 'direction1.txt';
dir_data =load(dir_name);
dir = dir_data(:,1);
[m n]=size(dir);
L = m * n;
plot(dir);
for i=1:L
    if dir(i)<-90 
        dir(i) = dir(i) + 360
    end
end
%计算采样次数
x = randperm(L);
figure;
plot(smooth(dir,10),'-k');
figure;
plot(dir,'-b');