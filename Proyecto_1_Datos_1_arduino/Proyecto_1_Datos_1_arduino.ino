

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
byte LastStateRC = LOW;

byte lastStateButton1 = LOW;
byte lastStateButton2 = LOW;
byte lastStateButton3 = LOW;
byte lastStateButton4 = LOW;
byte lastStateButton5 = LOW;


byte lastButtonStateRC;
byte lastButtonStatePlay;
byte PlayState = HIGH;

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
  delay(250);
  valpot = analogRead(A1);
  byte lastButtonStateRC = digitalRead(RCButton);
  byte lastButtonStatePlay = digitalRead(playButton);
  byte lastButtonStateT = digitalRead(nextButton);
  byte lastButtonStateP = digitalRead(previousButton);

  int sensorValue = analogRead(A1);

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
  byte buttonStatePlay;

    if(buttonStatePlay != lastButtonStatePlay){
      lastButtonStatePlay = buttonStatePlay;
      if (buttonStatePlay == LOW){
        if(PlayState == HIGH){
          PlayState = LOW;
          }
          else{
           PlayState = HIGH;
           
          }
      }
      
    }
 
  
  Serial.print(PlayState);
  Serial.print(";");
  Serial.print(lastButtonStateRC);
  Serial.print(";");
  Serial.print(lastButtonStateT);
  Serial.print(";");
  Serial.print(lastButtonStateP);
  Serial.print(";");
  Serial.print("\n");


}
