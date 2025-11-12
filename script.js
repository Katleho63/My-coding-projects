// --- search ---
const db=["case","requirements","collaboration","progress","ba tools","ict","business analysis"];
document.getElementById("searchForm").addEventListener("submit",e=>{
  e.preventDefault();
  const term=document.getElementById("searchInput").value.toLowerCase();
  alert(db.some(t=>t.includes(term))?`Found results for "${term}"`:`No results for "${term}".`);
});
// --- datetime ---
const dt=document.getElementById("datetime");
setInterval(()=>dt.textContent=new Date().toLocaleString("en-GB",{dateStyle:"full",timeStyle:"medium"}),1000);
// --- smooth scroll for tool links ---
document.querySelectorAll('#tools a').forEach(link=>{
  link.addEventListener('click',e=>{
    e.preventDefault();
    document.querySelector(link.getAttribute('href')).scrollIntoView({behavior:'smooth'});
  });
});

// ---------- Chatbot ----------
const toggleBtn = document.getElementById('chatToggle');
const chatModal = document.getElementById('chatModal');
const chatLog   = document.getElementById('chatLog');
const chatForm  = document.getElementById('chatForm');
const chatInput = document.getElementById('chatInput');

toggleBtn.addEventListener('click', ()=> {
  chatModal.classList.toggle('open');
  chatInput.focus();
});

// very small knowledge base
const answers = {
  case:    "You can view sample cases in the Case Study section above. Try Retail or Healthcare!",
  toolkit: "Download templates or upload your doc in the Requirements Toolkit section.",
  progress:"Check your badges and the blue progress bar under Progress Tracker.",
  hello:   "Hello there 👋 How can I help you today?"
};

chatForm.addEventListener('submit', e=>{
  e.preventDefault();
  const msg = chatInput.value.trim();
  if(!msg) return;
  addLine(msg,'user');
  chatInput.value='';

  // simple keyword match
  const key = Object.keys(answers).find(k=>msg.toLowerCase().includes(k));
  const reply = key? answers[key] : "Sorry, I’m still learning. Try asking about case studies, toolkit, or progress.";
  setTimeout(()=>addLine(reply,'bot'), 400);
});

function addLine(text, who){
  const p = document.createElement('p');
  p.textContent = text;
  p.className = who;
  chatLog.appendChild(p);
  chatLog.scrollTop = chatLog.scrollHeight;
}
// ----- Drag-and-Drop Badges -----
const board = document.getElementById('badgeBoard');
let dragged;

board.addEventListener('dragstart', e=>{
  dragged = e.target;
  e.dataTransfer.effectAllowed = "move";
});
board.addEventListener('dragover', e=> e.preventDefault());
board.addEventListener('drop', e=>{
  e.preventDefault();
  if(e.target.tagName === 'LI' && e.target !== dragged){
    board.insertBefore(dragged, e.target.nextSibling);
  }
});
// keyboard reorder (↑↓)
board.addEventListener('keydown', e=>{
  if(e.target.tagName!=='LI') return;
  const key = e.key;
  const current = e.target;
  if(key==='ArrowUp' && current.previousElementSibling){
    board.insertBefore(current, current.previousElementSibling);
  }
  if(key==='ArrowDown' && current.nextElementSibling){
    board.insertBefore(current.nextElementSibling, current);
  }
});
// ----- File name display -----
const reqInput = document.getElementById('reqFile');
if(reqInput){
  reqInput.addEventListener('change', ()=>{
    document.getElementById('fileName').textContent = reqInput.files[0]?.name || '';
  });
}

// --------- Dynamic Progress Tracker with Persistence ---------
const PROGRESS_KEY = "baProgress";
let progress = 0;
const completed = new Set(JSON.parse(localStorage.getItem(PROGRESS_KEY)) || []);

const progressBar = document.querySelector('.progress-bar');
const fill        = document.getElementById('progressFill');

function renderProgress() {
  progress = completed.size * 25;                 // 4 milestones → 25 % each
  fill.style.width = `${progress}%`;
  fill.textContent  = `${progress}% Complete`;
  progressBar.setAttribute("aria-valuenow", progress);
}
renderProgress();

function updateProgress(step) {
  if (completed.has(step)) return;                // already counted
  completed.add(step);
  localStorage.setItem(PROGRESS_KEY, JSON.stringify(Array.from(completed)));
  renderProgress();
}

// ========== Milestone listeners ==========
toggleBtn?.addEventListener('click', () => updateProgress('chat'));               // chatbot opened
reqInput ?.addEventListener('change', () => updateProgress('file'));              // file uploaded
document.querySelector('#collabSection button')
  ?.addEventListener('click', () => {
      const msg = document.querySelector('#collabSection textarea')?.value.trim();
      if (msg) updateProgress('discussion');                                      // message posted
  });
window.addEventListener('scroll', () => {                                         // scrolled to case section
  const caseSec = document.getElementById('caseSection');
  if (!completed.has('case') &&
      caseSec.getBoundingClientRect().top < window.innerHeight / 2) {
        updateProgress('case');
  }
});

// Milestone 1: Chatbot opened
toggleBtn?.addEventListener('click', () => updateProgress('chat'));

// Milestone 2: File uploaded
reqInput?.addEventListener('change', () => updateProgress('file'));

// Milestone 3: Discussion posted
document.querySelector('#collabSection button')?.addEventListener('click', () => {
  const msg = document.querySelector('#collabSection textarea')?.value.trim();
  if (msg) updateProgress('discussion');
});

// Milestone 4: Scroll to case study
window.addEventListener('scroll', () => {
  const caseSec = document.getElementById('caseSection');
  if (!completed.has('case') && caseSec.getBoundingClientRect().top < window.innerHeight / 2) {
    updateProgress('case');
  }
});

// --------- Help icon toggles the tour modal ---------
const helpBtn = document.getElementById('helpToggle');

helpBtn?.addEventListener('click', ()=>{
  tourModal.classList.add('open');
  tourModal.setAttribute("aria-hidden","false");
});

// ---------- Highlight active tool link ----------
const toolLinks = document.querySelectorAll('#tools ul li a');

toolLinks.forEach(link=>{
  link.addEventListener('click', e=>{
    // remove previous active state
    toolLinks.forEach(l=>l.classList.remove('active'));
    // set this link active
    e.currentTarget.classList.add('active');
  });
});

// optional: auto-highlight while scrolling into sections
const observer = new IntersectionObserver(entries=>{
  entries.forEach(entry=>{
    const id = entry.target.id;
    if(entry.isIntersecting){
      toolLinks.forEach(l=>{
        l.classList.toggle('active', l.getAttribute('href') === `#${id}`);
      });
    }
  });
},{root:null,rootMargin:'0px',threshold:0.4});   // 40 % of section visible

['caseSection','toolkitSection','collabSection','progressSection']
  .forEach(secId=>{
    const sec = document.getElementById(secId);
    if(sec) observer.observe(sec);
  });

// --------- Quick Start Tour ---------
const TOUR_KEY = 'baTourViewed';
const tourModal = document.getElementById('tourModal');
const closeTour = document.getElementById('closeTour');

if (!localStorage.getItem(TOUR_KEY)) {
  window.addEventListener('load', () => {
    tourModal?.classList.add('open');
    tourModal?.setAttribute("aria-hidden", "false");
  });
}

closeTour?.addEventListener('click', () => {
  tourModal?.classList.remove('open');
  tourModal?.setAttribute("aria-hidden", "true");
  localStorage.setItem(TOUR_KEY, 'true');
});

function updateProgress(step) {
    if (completed.has(step)) return;
    completed.add(step);
    localStorage.setItem(PROGRESS_KEY, JSON.stringify(Array.from(completed)));
    renderProgress();
  
    // 🎉 Trigger badge pop-up when 100%
    if (completed.size === 4) {
      document.getElementById('badgeModal')?.classList.add('show');
    }
  }
  
  document.getElementById('closeBadge')?.addEventListener('click', () => {
    document.getElementById('badgeModal')?.classList.remove('show');
  });
  
