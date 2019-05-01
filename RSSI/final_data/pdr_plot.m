filename = 'pdr_data5.txt';
data =load(filename);
dir = data(:,1);
len = data(:,2);
[step n] = size(dir)
x = -2.2;
y = 17;
start = [x,y];
angle_init = 0;
for i = 1 : step
    x = x + len(i) * cos(deg2rad(dir(i)-angle_init));
    y = y + len(i) * sin(deg2rad(dir(i)-angle_init));
    start = [start;x,y];
end
x =start(:,1);
y =start(:,2);
plot(x,y,'o');
x1 = -2.2;
y1 = 17;
real =[x1,y1];
step1 = 28;
step2 = 11;
step3 = step - step1 -step2;
for i = 1 : step1
    y1 = y1 - 0.6;
    real = [real;x1,y1];
end
for i = 1 : step2
    x1 = x1 + 0.6;
    real = [real;x1,y1];
end
for i = 1 : step3
    y1 = y1 + 0.6;
    real = [real;x1,y1];
end
hold on;
plot(real(:,1),real(:,2),'*');
for i = 1 : step
    e(i) = norm(start(i,:)-real(i,:));
end
figure;
plot(e);