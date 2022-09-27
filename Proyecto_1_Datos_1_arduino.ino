

int ledVol1 = 7;
int ledVol2 = 6;
int ledVol3 = 5;
int ledVol4 = 4;
int ledVol5 = 3;
int valpot;
byte play = 0;
int playLed = 2;
int playButton = 1;
int nextButton = 8;
int previousButton = 9;
byte RC = 0;
int RCPlayLed = 12;
int RCButton = 11;

  
void setup() {
  pinMode(ledVol1, OUTPUT);
  pinMode(ledVol2, OUTPUT);
  pinMode(ledVol3, OUTPUT);
  pinMode(ledVol4, OUTPUT);
  pinMode(ledVol5, OUTPUT);
  pinMode(playButton, INPUT);
  pinMode(playLed, OUTPUT);
  pinMode(nextButton, INPUT);
  pinMode(previousButton, INPUT);
  pinMode(RCButton, INPUT);
  pinMode(RCPlayLed, OUTPUT);
  Serial.begin(9600);
  //Serial2.begin(9600)
}

void loop() {
  
  valpot = analogRead(A1);
  
  if (valpot >= 0 && valpot < 205) {
    digitalWrite (ledVol1, HIGH);
    digitalWrite (ledVol2, LOW);
    digitalWrite (ledVol3, LOW);
    digitalWrite (ledVol4, LOW);
    digitalWrite (ledVol5, LOW);
    
  }
  
  if (valpot >= 205 && valpot < 409) {
    digitalWrite (ledVol1, HIGH);
    digitalWrite (ledVol2, HIGH);
    digitalWrite (ledVol3, LOW);
    digitalWrite (ledVol4, LOW);
    digitalWrite (ledVol5, LOW);
  }
  
  if (valpot >= 409 && valpot < 614) {
    digitalWrite (ledVol1, HIGH);
    digitalWrite (ledVol2, HIGH);
    digitalWrite (ledVol3, HIGH);
    digitalWrite (ledVol4, LOW);
    digitalWrite (ledVol5, LOW);
  }
  
  if (valpot >= 614 && valpot < 818) {
    digitalWrite (ledVol1, HIGH);
    digitalWrite (ledVol2, HIGH);
    digitalWrite (ledVol3, HIGH);
    digitalWrite (ledVol4, HIGH);
    digitalWrite (ledVol5, LOW);
  }
  
  if (valpot >= 818 && valpot < 1023) {
    digitalWrite (ledVol1, HIGH);
    digitalWrite (ledVol2, HIGH);
    digitalWrite (ledVol3, HIGH);
    digitalWrite (ledVol4, HIGH);
    digitalWrite (ledVol5, HIGH);
  }
    
  if (digitalRead(playButton == HIGH)){
    play =1;
    //playSong()
    //Serial.write(1);
    //delay(1);

  }
  
  if (play == true){
    digitalWrite(playLed, HIGH);

  }
  
  if (play == false){
    digitalWrite(playLed, LOW);
  }
  
  if (digitalRead(nextButton) == HIGH){
    //nextSong();
    play = play;
  }
  
  if (digitalRead(previousButton) == HIGH){
    //previousSong();
    play = play;
  }
  
  if (digitalRead(RCButton == HIGH)){
    RC = 1;
    //continuousPlay()
  }
  
  if (RC == true){
    digitalWrite(RCPlayLed, HIGH);
  }
  
  if (RC == false){
    digitalWrite(RCPlayLed, LOW);
  }
  Serial.print(play);
  Serial.print(";");
  Serial.print(RC);


}
